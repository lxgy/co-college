// 获取元素
var textarea = document.getElementsByClassName('textarea');
// 生成编辑器
var editor = new wangEditor(textarea);
editor.config.menus = [
	'source',
	'|',
	'bold',
	'underline',
	'italic',
	'strikethrough',
	'eraser',
	'forecolor',
	'bgcolor',
	'|',
	'quote',
	'fontfamily',
	'fontsize',
	'head',
	'unorderlist',
	'orderlist',
	'alignleft',
	'aligncenter',
	'alignright',
	'|',
	'link',
	'unlink',
	'table',
	'|',
	'img',
	'insertcode',
	'|',
	'undo',
	'redo',
	'fullscreen'
];
editor.create();
$(".add_chapter").click(function() {
	$(".textarea").attr("class", "")
	var str = "<div class='row cl'>" +
		"<label class='form-label col-xs-4 col-sm-3'>章节名称：</label>" +
		"<div class='formControls col-xs-8 col-sm-9'>" +
		"	<input type='chapter' class='input-text' name='chapter_name' >" +
		"</div>" +
		"</div>" +
		"<div class='row cl'>" +
		"	<label class='form-label col-xs-4 col-sm-3'>章节内容：</label>" +
		"	<div class='formControls col-xs-8 col-sm-9'>" +
		"		<textarea class='textarea' name='content' style='height: 25em;'>" +
		"		</textarea></div> " +
		"	</div>";
	$(this).parent().parent().before(str);
	var textarea = document.getElementsByClassName('textarea');
// 生成编辑器
var editor = new wangEditor(textarea);
	editor.create();
})