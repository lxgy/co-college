$(document).ready(function() {

	var email,
		password,
		repassword;

	$("#email").bind('input propertychange', function() {
		var email_val = $("#email").val();
		email = email_rules();
	});

	$("#password").bind('input propertychange', function() {
		password = password_rules();
	});

	$("#repassword").bind('input propertychange', function() {
		password = $("#password").val(),
			repassword = $("#repassword").val();
		if (repassword != password) {
			$("#repassword-success").text("");
			$("#repassword-msg").text("两次密码不一致");
			$("#repassword").focus();
			repassword = false;
		} else {
			repassword = true;
			$("#repassword-msg").text("");
			$("#repassword-success").text("密码一致");
		}
	});


	// 腾讯防水墙验证码
	var tencentCaptchaVertify = new TencentCaptcha(document.getElementById("regist-btn"), '2002199216',
		function(res) {
			var regist_data = $("#registF").serialize();

			if (res.ret == 0) {
				email = email_rules();
				if (email) {
					password = password_rules();
				}
				if (password) {
					repassword = repassword_rules();
				}

				var protocol = $("#access-protocol").get(0).checked;

				if (email && password && repassword && protocol) {
					$.ajax({
						type: 'post',
						url: '/user/regist',
						data: regist_data,
						dataType: 'json',
						success: function(result) {
							if(result.code == 200){
								document.location.href= "/front/page/send_email/" + result.data.email;
							}else{
								layer.msg("请重新注册");
							}
						},
						error: function(xhr) {
							console.log(xhr);
						}
					});
				}
			}
		});
	$(".protocol").click(function () {
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: ['80%','80%']
            ,shade: 0.8
			,closeBtn:2
			,shadeClose:true
            ,id: 'xieyi' //设定一个id，防止重复弹出
            ,resize: false
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding:0px 60px;"><h4 style="font-weight: bold; text-align: center;">砺锋众创学院网站会员服务协议</h4><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 欢迎阅读砺锋众创学院网站会员服务协议（ 下称“ 本协议”）。 本协议是您与砺锋众创学院网站所有者之间就您使用砺锋众创学院网站（ www.u - cto.com， 下称“ 本网站”） 的所有服务等相关事宜订立的契约， 一经您注册成为本网站会员， 本协议即构成对双方有约束力的法律文件。 </p> <strong> 一、 特别提示 </strong> <p>     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 1.1 在您决定成为本网站注册会员之前， 请仔细阅读本会员服务条款。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;1.2 以任何方式进入本网站并使用服务即表示您已充分阅读、 理解并同意接受本协议的条款和条件（ 以下合称“ 条款”）。 阅读本协议的过程中， 如果您不同意本协议或其中任何条款约定， 您应立即停止注册程序。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;1.3 由于互联网高速发展， 您与本网站签署的本协议列明的条款并不能完整罗列并覆盖您与本网站所有权利与义务， 现有的约定也不能保证完全符合未来发展的需求。 因此， 本网站法律声明及隐私权政策、 规则均为本协议的补充协议， 与本协议不可分割且具有同等法律效力。 如您使用本网站服务， 视为您同意上述补充协议。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;1.4 本网站有权根据业务需要修订条款， 并以网站公告的形式进行更新， 不再单独通知您。 修订的条款一经在本网站公布， 即产生效力。 如您不同意相关修订， 请您立即停止使用服务； 如您继续使用服务， 则表示您已经接受修订的条款。 当您与本网站发生争议时， 应以最新的条款为准。 </p> <strong> 二、 注册 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2.1 服务使用对象 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您确认， 在您完成注册程序或以其他本网站允许的方式实际使用服务时， 您应当是具备完全民事权利能力和所从事的民事行为相适应的行为能力的自然人、 法人或其他组织。 若您不具备前述主体资格， 请勿使用服务， 否则您及您的监护人应承担因此而导致的一切后果， 且本网站有权注销（ 永久冻结） 您的账户， 并向您及您的监护人索赔。 如您代表一家公司或其他法律主体在本网站登记， 则您声明和保证， 您有权使该公司或法律主体受本协议条款的约束。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2.2 注册账户 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;在进行注册或激活流程时， 您应当按照法律法规和本网站规则要求， 按相应页面的提示准确提供并及时更新您的资料， 以使之合法、 真实、 及时、 完整和准确。 如有合理理由怀疑您提供的资料有不合法、 不真实、 不及时、 不完整和不准确的情形， 本网站有权向您发出询问或要求改正的通知， 并有权直接做出删除相应资料的处理， 直至中止、 终止对您提供部分或全部网站服务， 本网站对此不承担任何责任， 您将承担因此产生的任何直接或间接损失及不利后果。 </p> <strong> 三、 账户安全 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您注册成功后， 将产生用户名和密码等账户信息， 您可以根据本网站规则改变您的密码。 您应谨慎合理的保存、 使用用户名和密码， 并确保您在每个上网时段结束时退出登录并以正确步骤离开本网站。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;对您的个人信息， 本站将予以严格保密， 除非得到您的授权或法律另有规定， 本网站不会向外界披露您的隐私信息。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您若发现任何非法使用用户账号或存在安全漏洞的情况， 请立即通知本网站， 以便本网站采取相应措施。 账户因您主动泄露或遭受他人攻击、 诈骗等行为导致的损失及后果， 均由您自行承担。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您同意自行负责对您的账号和密码下发生的所有活动（ 包括但不限于信息披露、 发布信息、 网上点击同意或提交各类规则协议、 网上续签协议或购买服务等） 承担责任。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;出于服务用户的目的， 本网站可能通过使用您的个人信息， 向您提供服务， 包括但不限于向您发出产品和服务信息。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您同意本网站有权使用您的注册信息、 用户名、 密码等信息， 登录进入您的注册账户， 进行证据保全， 包括但不限于公证、 见证等。 </p> <strong> 四、 服务使用规范 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;4.1 您的资料包括您在注册、 发布信息或交易过程中， 在任何公开信息场合或通过任何电子形式， 向本网站或其他用户提供的任何资料， 包括数据、 文本、 软件、 音乐、 声响、 照片、 图画、 影像、 词句或其他材料。 您应对您的资料负全部责任， 而本网站仅作为您在网上发布和刊登您的资料的被动渠道。 但是， 倘若本网站认为您的资料可能使本网站承担任何法律或道义上的责任， 或可能使本网站(全部或部分地) 失去本网站的互联网服务供应商或其他供应商的服务， 或您未在本网站规定的期限内登录或再次登录网站， 则本网站可自行全权决定对您的资料采取本网站认为必要或适当的任何行动， 包括但不限于删除该类资料。 您特此保证， 您对提交给本网站的您的资料拥有全部权利， 包括全部版权。 您确认， 本网站没有责任去认定或决定您提交给本网站的资料哪些是应当受到保护的， 对享有本网站服务的其他用户使用您的资料， 本公司也不必负责。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;4.2 您同意并承诺， 您的资料和您在本网站上交易的任何物品（ 泛指一切可供依法交易的、 有形的或无形的、 以各种形态存在的某种具体的物品， 或某种权利或利益， 或某种票据或证券， 或某种服务或行为。 本协议中“ 物品” 一词均含此义）： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;①不会有欺诈成份， 与售卖伪造或盗窃无涉； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;②不会侵犯任何第三者对该物品享有的物权， 或版权、 专利、 商标、 商业秘密或其他知识产权， 或隐私权、 名誉权； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;③不会违反任何法律、 法规、 条例或规章(包括但不限于关于规范出口管理、 凭许可证经营、 贸易配额、 保护消费者、 不正当竞争或虚假广告的法律、 法规、 条例或规章)、 本协议及相关规则； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;④不会含有诽谤（ 包括商业诽谤）、 非法恐吓或非法骚扰的内容； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;⑤不会含有淫秽或包含任何儿童色情内容； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;⑥不会含有蓄意毁坏、 恶意干扰、 秘密地截取或侵占任何系统、 数据或个人资料的任何病毒、 伪装破坏程序、 电脑蠕虫、 定时程序炸弹或其他电脑程序； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;⑦不会直接或间接与下述各项货物或服务连接， 或包含对下述各项货物或服务的描述： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;(i) 本协议项下禁止的货物或服务； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;(ii) 您无权连接或包含的货物或服务。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;此外， 您同意不会： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;(ⅲ) 在与任何连锁信件、 大量胡乱邮寄的电子邮件、 滥发电子邮件或任何复制或多余的信息有关的方面使用本网站服务； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;(iv) 未经其他人士同意， 利用本网站服务收集其他人士的电子邮件地址及其他资料； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;(v) 利用本网站服务制作虚假的电子邮件地址， 或以其他形式试图在发送人的身份或信息的来源方面误导其他人士； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;⑧不含有本网站认为应禁止或不适合通过本网站宣传或交易的内容。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;4.3 您同意， 您不会对任何资料作商业性利用， 包括但不限于在未经本网站事先书面批准的情况下， 复制在本网站站上展示的任何资料并用于商业用途。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;4.4 您不得在本网站公布或通过本网站买卖： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;①可能使本网站违反任何相关法律、 法规、 条例或规章的任何物品； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;②本网站认为应禁止或不适合通过本网站买卖的任何物品。 </p> <strong> 五、 服务终止 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;5.1 您同意， 在本网站未向您收费的情况下， 本网站可自行全权决定以任何理由（ 包括但不限于本网站认为您已违反本协议的字面意义和精神， 或您以不符合本协议的字面意义和精神的方式行事， 或用户在超过90天的时间内未以用户的账号及密码登录网站等） 终止您的账户（ 或其它任何部分） 及密码或您对本网站服务的使用， 并不再保存您在使用本网站服务中提交的任何资料。 同时本网站可自行全权决定， 在发出通知或不发出通知的情况下， 随时停止提供本网站服务或其任何部份。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;5.2 您有权向本网站要求注销您的账户， 经本网站审核同意的， 本网站将注销您的账户， 届时您与本网站基于本协议的合同关系即终止。 您的账户被注销后， 本网站没有义务为您保留或向您披露账户中的任何信息， 也没有义务向您或第三方转发任何您未曾阅读或发送过的信息。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;5.3 您理解并同意， 您与本网站的合同关系终止后： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;①本网站有权继续保存您的资料； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;②您在使用本网站服务期间存在违法行为或违反本协议或规则的行为， 本网站仍可依据本协议向您主张权利； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;③您在使用本网站服务期间因使用服务与其他用户之间发生的关系， 不因本协议的终止而终止， 其他用户仍有权向您主张权利， 您应继续按您的承诺履行义务。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;④本网站不会就终止您接入本网站服务而对您或任何第三者承担任何责任。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;5.4 本协议终止后， 对于您在本协议存续期间产生的交易， 本网站可通知交易相对方并根据交易相对方的意愿决定是否关闭该等交易； 如交易相对方要求继续履行的， 则您应当就该等交易继续履行本协议及交易的约定， 并承担因此产生的任何损失或增加的任何费用。 </p> <strong> 六、 免责声明 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;6.1 您明确理解和同意， 本网站不对因下述任一情况而发生的任何损害赔偿承担责任， 包括但不限于利润、 商誉、 使用、 数据等方面的损失或其他无形损失的损害赔偿(无论本网站是否已被告知该等损害赔偿的可能性)： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;①使用或未能使用本网站服务； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;②因通过或从本网站服务购买或获取任何货物、 样品、 数据、 资料或服务， 或通过或从本网站服务接收任何信息或缔结任何交易所产生的获取替代货物和服务的费用； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;③未经批准接入或更改您的传输资料或数据； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;④任何第三者对本网站服务的声明或关于本网站服务的行为； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;⑤因任何原因而引起的与本网站服务有关的任何其他事宜， 包括疏忽。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;6.2 本网站会尽一切努力使您在使用本网站的过程中得到乐趣。 遗憾的是， 本网站不能随时预见到任何技术上的问题或其他困难。 该等困难可能会导致数据损失或其他服务中断。 为此， 您明确理解和同意， 您使用本网站服务的风险由您自行承担， 且本网站服务以“ 按现状” 和“ 按可得到” 的状态提供。 本网站明确声明不作任何种类的明示或暗示的保证， 包括但不限于关于适销性、 适用于某一特定用途和无侵权行为等方面的保证。 本网站对下述内容不作保证： </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;①本网站服务会符合您的要求； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;③通过使用本网站服务而可能获取的结果将是准确或可信赖的； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;②本网站服务不会中断， 且适时、 安全和不带任何错误； </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;④您通过本网站服务而购买或获取的任何产品、 服务、 资料或其他材料的质量将符合您的预期。 通过使用本网站服务而下载或以其他形式获取任何材料是由您自行全权决定进行的， 且与此有关的风险由您自行承担， 对于因您下载任何该等材料而发生的您的电脑系统的任何损毁或任何数据损失， 您将自行承担责任。 您从本网站或通过或从本网站服务获取的任何口头或书面意见或资料， 均不产生未在本协议内明确载明的任何保证责任。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;6.3 本网站服务或第三者均可提供与其他万维网网站或资源的链接。 由于本网站并不控制该等网站和资源， 您承认并同意， 本网站并不对该等外在网站或资源的可用性负责， 且不认可该等网站或资源上或可从该等网站或资源获取的任何内容、 宣传、 产品、 服务或其他材料， 也不对其负责或承担任何责任。 您进一步承认和同意， 对于任何因使用或信赖从此类网站或资源上获取的此类内容、 宣传、 产品、 服务或其他材料而造成（ 或声称造成） 的任何直接或间接损失， 本网站均不承担责任。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;6.4 因您本人遗忘密码、 误操作、 更换号码等导致您在本网站中的信息丢失或不能继续使用会员服务的， 本网站均不承担责任。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;6.5 对于因本网站合理控制范围以外的原因， 包括但不限于自然灾害、 罢工或骚乱、 物质短缺或定量配给、 暴动、 战争行为、 政府行为、 通讯或其他设施故障或严重伤亡事故等， 致使本网站延迟或未能履约的， 本网站不对您承担任何责任。 </p> <strong> 七、 赔偿 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您同意， 如因您违反本协议或经在此提及而纳入本协议的其他文件， 或因您违反法律侵害了第三方的合法权利， 或因您违反法律须承担行政或刑事责任， 而使第三方或行政、 司法机关对本网站及其董事、 职员、 代理人提出索赔或处罚要求（ 包括司法费用和其他专业人士的费用）， 您必须全额赔偿给本网站及其董事、 职员、 代理人等,以保证其免遭损失。 </p> <strong> 八、 通知 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;您应当准确填写并及时更新您提供的电子邮件地址、 联系电话、 联系地址、 邮政编码等联系方式， 以便本网站或其他用户与您进行有效联系， 因通过这些联系方式无法与您取得联系， 导致您在使用本网站服务过程中产生任何损失或增加费用的， 应由您完全独自承担。 您了解并同意， 您有义务保持您提供的联系方式的有效性， 如有变更需要更新的， 您应按本网站的要求进行操作。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;除非另有明确规定， 任何您与本网站之间的通知应以电子邮件形式发送，(就本网站而言) 电子邮件地址为294008938 @qq.com， 或(就您而言) 发送到您在登记注册过程中向本网站提供的电子邮件地址， 或有关方指明的该等其他地址。 在电子邮件发出二十四(24) 小时后， 通知应被视为已送达， 除非发送人被告知相关电子邮件地址已作废。 或者本网站可通过邮资预付挂号邮件并要求回执的方式， 将通知发到您在登记过程中向本网站提供的地址。 在该情况下， 在付邮当日三(3) 天后通知被视为已送达。 </p> <strong> 九、 法律说明 </strong> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;9.1 本协议之效力、 解释、 变更、 执行与争议解决均适用中华人民共和国大陆地区法律， 如无相关法律规定的， 则应参照通用国际商业惯例和（ 或） 行业惯例。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;9.2 您与本网站仅为独立订约人关系。 本协议无意结成或创设任何代理、 合伙、 合营、 雇佣与被雇佣或特性授权与被授权关系。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;9.3 您同意本网站因经营业务需要有权将本协议项下的权力义务就部分或全部进行转让， 而无须再通知予您并取得您的同意。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;9.4 因本协议或本网站服务所引起或与其有关的任何争议应向本网站所在地人民法院提起诉讼。 </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;9.5 本协议取代您和本网站先前就相同事项订立的任何书面或口头协议。 倘若本协议任何条款被裁定为无效或不可强制执行， 该项条款应被撤销， 而其余条款应予遵守和执行。 条款标题仅为方便参阅而设， 并不以任何方式界定、 限制、 解释或描述该条款的范围或限度。 本网站未就您或其他人士的某项违约行为采取行动， 并不表明本网站撤回就任何继后或类似的违约事件采取动的权利。 </p></div>'
        });
    })
});

function email_rules() {
	var result, email_val = $("#email").val();
	if (email_val == "" || email_val == null) {
		$("#email-success").text("");
		$("#email-msg").text("* 邮箱不能为空");
		$("#email").focus();
		result = false;
	} else {
		var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		if (!reg.test(email_val)) {
			$("#email-success").text("");
			$("#email-msg").text("* 请填写正确的邮箱格式");
			$("#email").focus();
			result = false;
		} else {
			$("#email-msg").text("");
			$("#email-success").text("邮箱可用");
			result = true;
		}
	}
	if (result) {
		$.ajax({
			type: 'post',
			url: '/user/validate_email',
			data: {
				email: email_val
			},
			dataType: 'json',
			async:false,
			success: function(data) {
				if (data.code == 200) {
					result = true;
					$("#email-msg").text("");
					$("#email-success").text(data.msg);
				} else {
					result = false;
					$("#email-success").text("");
					$("#email-msg").text(data.msg);
				}
			},
			error: function(xhr) {
				layer.msg("请刷新重试");
				console.log(xhr);
			}
		});
	}
	return result;
}

function password_rules() {
	var result, password_val = $("#password").val();
	if (password_val == "" || password_val == null) {
		$("#password-success").text("");
		$("#password-msg").text("* 密码不能为空");
		$("#password").focus();
		result = false;
	} else {
		var reg = /^\w{6,18}$/;
		if (!reg.test(password_val)) {
			$("#password-success").text("");
			$("#password-msg").text("* 密码由6-18位的数字、字母、下划线组成");
			$("#password").focus();
			result = false;
		} else {
			$("#password-msg").text("");
			$("#password-success").text("密码可用");
			result = true;
		}
	}
	return result;
}

function repassword_rules() {
	var result,
		password = $("#password").val(),
		repassword = $("#repassword").val();
	if (password != repassword) {
		$("#repassword").text("两次密码不一致");
		$("#repassword").focus();
		result = false;
	} else {
		result = true;
		$("#repassword-msg").text("");
		$("#repassword-success").text("密码一致");
	}
	return result;
}
