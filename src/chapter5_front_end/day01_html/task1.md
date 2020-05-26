1. HTML 是什么？

HyperText Markup Language

2. HTML 基本结构？ 请给出示例代码
```html
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>

</body>
</html>

```

3. HTML 注释
```html
<!--	屏幕适应的设置-->
```

4. HTML <head></head> 中包含哪些标签？
```html
<meta> 
<title>
```


5. HTML 文本标签和格式化标签有哪些？
```html
	<h1>H1标题标签</h1>
	<h2>H2标题标签</h2>
	<h3>H3标题标签</h3>
	<h4>H4标题标签</h4>
	<h5>H5标题标签</h5>
	<h6>H6标题标签</h6>

	<u>u下划线标签</u><br/>
	<del>del删除线标签</del><br/>
	<b>b加粗标签</b><br/>
	<strong>strong强调加粗标签</strong><br/>
	<i>i斜体标签</i><br/>
	<em>em强调斜体标签</em><br/>
	<br/>
	<cite>清明上河图</cite>是我国十大传世名画之一 <br/><br/>
```

```html
<h1>HTML格式化标签</h1>
    <hr/>

    <div style="width:600px">
        <p>
            新华社北京2月29日电 3月1日出版的第5期《求是》
            杂志将发表中共中央总书记、<br/>国家主席、
            中央军委主席习近平的重要文章《全面提高依法防控依法治理能力，
            健全国家公共卫生应急管理体系》。
        </p>
        <p>
    　　    文章强调，确保人民群众生命安全和身体健康，
            是我们党治国理政的一项重大任务。
            要始终把人民群众生命安全和身体健康放在第一位，
            从立法、执法、司法、守法各环节发力，切实推进依法防控、
            科学防控、联防联控。既要立足当前，科学精准打赢疫情防控阻击战，
            更要放眼长远，总结经验、吸取教训，针对这次疫情暴露出来的短板和不足，
            抓紧补短板、堵漏洞、强弱项，完善重大疫情防控体制机制，
            健全国家公共卫生应急管理体系。
        </p>
    </div>

    你的爱好：
    <ul type="circle">
        <li>看书</li>
        <li>上网</li>
        <li>爬山</li>
        <li>唱歌</li>
    </ul>

    <ol type="1">
        <li>看书</li>
        <li>上网</li>
        <li>爬山</li>
        <li>唱歌</li>
    </ol>

<!--    自定义列表-->
    <dl>
        <dt>问：HTML是什么？</dt>
        <dd>答：超文本标记语言</dd>
        <dt>问：CSS是什么？</dt>
        <dd>答：层叠样式表</dd>
    </dl>


    <div>aaaaa</div><div>bbbbb</div><span>cccccc</span><span>dddddd</span>

```