DataDirService
==============

DataDirService предназначен для задания коротких постоянных имён (алиасов) для каталогов. 
Придуманные постоянные имена можно использовать для обращения каталогам (метод `getPath`), 
реальное разположение которых можно менять и задавать через конфиг.   

#### Пример 1 
Задаем расположение каталогов:
``` xml
<?xml version="1.0" encoding="utf-8"?>
<root>
    <datadir>
        <path name="my-root" path="C:/Program Files (x86)/Windows Defender/"/>
        <path name="temp" path="D:/Temp/.jandcode-cache"/>
    </datadir>
</root>
``` 

Использование в приложении:

@@code file=tutorial/_inc/dadatir/DataDir_Test.java part=part1

Выведет на печть:

``` txt
my-root = C:\Program Files (x86)\Windows Defender
temp = D:\Temp\.jandcode-cache 
``` 

#### Пример 2 

Модификация метода `getPath` с дополнительным параметром `localPath` вернет каталог `localPath` относительно каталога `name`

@@code file=tutorial/_inc/dadatir/DataDir_Test.java part=part2

Выведет на печть:

``` txt
my-temp-file = D:\Temp\.jandcode-cache\internal-dir\file1.txt
``` 
