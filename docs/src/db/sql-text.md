
SqlText
=======

Объект для хранения текста sql и манипуляций с ним. 

Заменяемые части sql
--------------------

### select

Часть текста sql между `select` и `from`. Для сложных sql, где и `select` и `from` может
встречаться много раз, слова помечаются коментарием
`/**/`, который ставится до `select` или `from`:

```sql
select * from aaa where 0=0 order by id

/**/select * /**/from aaa where 0=0 and (b in select a from c) order by id
```

Используется для подмены или дополнения списка полей. Например, для запроса общего количества
записей можно заменить поля в select на `count(*) as cnt`.


### where

Место вставки условия фильтрации. Автоматически выявляется по наличию слова `where`
в тексте запроса, после которого и вставляется условие фильтрации. 

Если в тексте sql несколько `where`, то нужный помечается коментарием `/**/` до `where`. 

Если в тексте sql имеется несколько `where`, в которых нужно разместить условия фильтрации,
то место вставки помечается коментарием `/*where:name*/`, где `name` - имя `where`.
Коментарий `/*where*/` эквивалентен `/*where:default*/`.

Существующие условия фильтрации дополняются новымы через `and`.

```sql
select * from aaa where 0=0 order by id

select * from aaa /**/where 0=0 order by id

select * from aaa where 0=0 /*where*/ order by id

select * from aaa where 0=0 /*where:default*/ order by id

select * from aaa /**/where 0=0 and (b in select a from c where c=1 /*where:w1*/) order by id
```

### order by

Место вставки сортировки. Автоматически выявляется по фразе `order by`. Если в тексте sql
несколько операторов order by, то нужный помечается коментарием `/**/`. Текст order by
рассматривается до конца текста sql либо до коментария `/*end*/`:

```sql
select * from aaa where 0=0 order by id

select * from aaa where 0=0 and
(b in select a from c where c=1 order by a)
/**/order by tab/*end*/ group by id
```

Используется для подмены сортировки или ее исключения.
          
### part

Место вставки произвольного фрагмента sql. Текст вставляется после коментария `/*part:XXX*/`.  

```sql
select * from aaa /*part:join1*/ where p1=1 /*part:where1*/
```
                                                                                             
