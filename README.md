Run test: mvn test  

Серия тестов свободного тестового API http://reqres.in/

Список тестов:
Добавить пользователя (POST CREATE)
- Выполнить post запрос на создание пользователя с определенными параметрами
- Проверить, что http код ответа = 201 (Created)

Обновить пользователя (PUT UPDATE)
- Выполнить put запрос на обновление пользователя с определенными параметрами
- Проверить, что http код ответа = 200 (http ok)
- Проверить, что возвращенные параметры "name" и "job" соответствуют переданным в теле put запроса

Получить список пользователей (GET LIST USERS)
- Получить список пользователей (GET LIST USERS)
- Проверить, что код ответа 200
- Найти идентификатор пользователя с указаным именем, сохранить его в переменную
- Запросить информацию по этому пользователю (GET SINGLE USER) используя полученный идентификатор
- Проверить, что у этого идентификатора следующие параметры совпадают с ожидаемыми 
- Проверить, что код ответа 200
