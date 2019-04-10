
Статья в формате html
=====================

Расширение файлов `.htm`.

Первый заголовок в теле статье - становится заголовком статьи и убирается из тела статьи.
Все остальные заголовки нормализуются, начиная с уровня `<h2>`.

```html
<h1>Заголовок статьи</h1>

<p>Текст статьи</p>
```

Можно указывать произвольные свойства статьи в теге `mdoc-props`:

```html
<mdoc-props>
    prop1=1
    prop2="2"
</mdoc-props>

<h1>Заголовок статьи</h1>

<p>Текст статьи</p>
```

Если в свойствах статьи указано свойство `title`, то его значение рассматривается как
заголовок статьи. В этом случае все остальные заголовки рассматриваются как внутренне
содержание и так же нормализуются, начиная с уровня `<h2>`.

```html
<mdoc-props>
    title=Заголовок статьи
</mdoc-props>

<p>Текст статьи</p>
```



 