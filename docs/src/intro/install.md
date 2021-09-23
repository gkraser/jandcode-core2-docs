
Установка
=========


Настройка среды
---------------

Перед установкой **Jandcode Core** необходимо настроить среду.
Должно быть установлено следующее:

* Java JDK, версия >=17
* [Gradle](https://gradle.org/), версия 7 или старше
* [Node.js](https://nodejs.org), версия 14.x или старше
* [Git](https://git-scm.com/), версия 2 или старше

Среда должна быть настроена так, что бы, что бы с командной строки
запускались приложения `java`, `javac`, `gradle`, `node`, `npm`, `git`.

!!! note "Поддержка IDE"
    Из коробки поддерживается только IDE 
    [IntelliJ IDEA](https://www.jetbrains.com/idea/), версия 2018 или старше.


Установка 
---------

!!! warning 
    Каталоги и имена файлов с пробелами не поддерживаются нигде.
    Все каталоги и файлы в используемых инструментах и проектах должны быть 
    без пробелов.

Проект **Jandcode Core** поставляется в исходниках и компилируется на машине
пользователя.

Исходники доступны в репозитории git: 
[](https://github.com/gkraser/jandcode-core2).  

### Шаг 1. Создание каталога для проектов

Создаем произвольный рабочий каталог для проектов (например 
`D:\jc-projects` для Windows или `~/jc-projects` для Linux) 
и переходим в него:


```text title=Windows 
cd /D D:\jc-projects
```

```text title=Linux
cd ~/jc-projects
```

### Шаг 2. Создание jc-env.bat

Создайте в каталоге проектов `D:\jc-projects` файл `jc-env.bat`
со следующим содержимым:

```txt title=jc-env.bat
@echo off

set JAVA_HOME=c:\tools\jdk15
set GRADLE_HOME=c:\tools\gradle
set NODE_HOME=c:\tools\nodejs

set PATH=%JAVA_HOME%\bin;%GRADLE_HOME%\bin;%NODE_HOME%;%PATH%

java -version
call gradle -version
call npm -version

echo -------------------------------------------------------------------------------------

set JC_RUN=%~dp0jandcode-core2\bin\jc-run.bat

```

Измените переменные `JAVA_HOME`, `GRADLE_HOME`, `NODE_HOME`
на значения, соответствующие вашей среде.

Запустите этот файл и убедитесь, что запускаются нужные вам версии
`java`, `gradle`, `npm`.

Строки, запускающие `gradle` и `npm`, можно будет потом закоментировать,
что бы не мешалось. Показ версии `java` рекомендую оставить,
что бы контролировать среду в случае, когда установлено несколько версий java.


### Шаг 3. Клонирование репозитория

Убеждаемся, что находимся в каталоге проектов (`D:\jc-projects` ).
Клонируем репозиторий:

```
git clone https://github.com/gkraser/jandcode-core2
```


### Шаг 4. Сборка

Переходим в каталог `D:\jc-projects\jandcode-core2` 
(для Linux `~/jc-projects/jandcode-core2`) и запускаем сборку проекта:

```text title=Windows
build-bin.bat
```

```text title=Linux
sh ./build-bin.sh
```

После окончания сборки имеем каталог `bin`, в котором собрана последняя
стабильная версия проекта. 


### Шаг 5. jc.bat / jc.sh

Необходимо обеспечить доступ к `jc.bat` (`jc.sh` для Linux) с командной строки.
Для этого:
 
* **Windows**: укажите каталог `D:\jc-projects\jandcode-core2\bin`
в переменной среды `PATH`, либо скопируйте файл 
`D:\jc-projects\jandcode-core2\bin\jc.bat` в каталог, который 
указан в переменной `PATH`.
* **Linux**: укажите каталог `$HOME/jc-projects/jandcode-core2/bin`
в переменной среды `PATH`, либо скопируйте файл 
`$HOME/jc-projects/jandcode-core2/bin/jc.sh` в каталог, который 
указан в переменной `PATH`. 

Убедитесь, что команда `jc` доступна:

```text title=Windows
where jc
```     

В выводе этой команды ваш настроенный `jc.bat` должен быть первым в списке.

### Шаг 6. Проверяем, что все работает

Переходим в каталог для проектов `D:\jc-projects` 
(для Linux `~/jc-projects`) и запускаем `jc`, что бы убедится, что все работает:

```text title="Windows"
cd /D D:\jc-projects
jc
```

```text title="Linux"
cd ~/jc-projects
jc
```

В выводе обращаем внимание, что `jc-home` указывает на каталог с собранным
проектом:

```text title="Windows"
 * jc-home: D:\jc-projects\jandcode-core2\bin
```   

```text title="Linux"
 * jc-home: /home/USERNAME/jc-projects/jandcode-core2/bin
```   

Готово.


Обновление
----------

!!! note
    Перед обновлением все запущенные процессы, которые используют
    обновляемый продукт, должны быть остановлены.
    
Что бы обновить версию до последней, выполните:

```text title="Windows"
cd /D D:\jc-projects\jandcode-core2
build-bin.bat
```

```text title="Linux"
cd ~/jc-projects/jandcode-core2
sh ./build-bin.sh
```

Если версия изменилась, продукт будет пересобран.


Ветки master и dev
-------------------

!!! warning
    В ветке `master` находится стабильный релиз. Работоспособность
    других веток и ревизий не гарантируется.

В репозитории имеются 2 основных ветки: `master` и `dev`.

Ветка `master` содержит последний стабильный релиз.

Ветка `dev` содержит текущую версию для разработки.

Вы можете собирать бинарный вариант продукта из любой ветки, даже из любой ревиизии.
Просто обновите рабочий каталог с исходниками **Jandcode Core** до нужной Вам
ветки или ревизии. Например для `dev`:

```text title="Windows"
cd /D D:\jc-projects\jandcode-core2
git pull
git checkout dev
build-bin.bat
```

```text title="Linux"
cd ~/jc-projects/jandcode-core2
git pull 
git checkout dev
sh ./build-bin.sh
```

Поддержка запуска jc версии 1.5
-------------------------------

Если вы используете Jandcode Core версии 1.5.x, то ее инструменты командной строки
так же запускаются через команду `jc`, которая конфликтует с новой версией. 

Для поддержки работоспособности старой версии
через новый вариант `jc.bat` необходимо в рабочем каталоге с проектам
на старой версии (в том, который содержит файл `jc-run.bat`) создать 
файл `jc-env.bat` с содержимым:

```
set JC_RUN=%~dp0jc-run.bat
```

Если Ваш старый `jc-run.bat` лежит в каком-то особом и загадочном месте,
то создайте файл `jc-env.bat` в каталоге выше Вашего проекта на старой версии
и в нем для переменной `JC_RUN` установите полный путь до `jc-run.bat`
старой версии.

Теперь запуск `jc` в рабочем каталоге с новой версией запустит новую,
а в рабочем каталоге со старой - старую.

 

