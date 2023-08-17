### Hexlet tests and linter status:
[![Actions Status](https://github.com/smyslovsv/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/smyslovsv/java-project-78/actions)
### CodeClimate status:
[![Maintainability](https://api.codeclimate.com/v1/badges/dc46a414fbccde44d076/maintainability)](https://codeclimate.com/github/smyslovsv/java-project-78/maintainability)

Этот проект содержит функции для проверки строк, чисел и карт. Проверка карты обеспечивает функциональность проверки структуры.

Чтобы использовать валидатор, необходимо создать объект валидатора и определить схему валидации данных.
Схема представляет собой объект, который содержит правила валидации данных, такие как обязательность заполнения,
минимальную и максимальную длину строки и так далее:
Создаем объект валидатора:
```sh
Validator v = new Validator();
```

Для проверки строк создаем схему:
```sh
StringSchema schema = v.string();
```
Схема содержит такой набор методов:
required() — добавляет в схему ограничение, которое не позволяет использовать null или пустую строку в качестве значения
minLength() — добавляет ограничение минимальной длины для строки. Строка должна быть равна или длиннее указанного числа
contains() — добавляет ограничение по содержимому строки. Строка должна содержать определённую подстроку.
После настройки ограничений необходимо вызвать метод .isValid().
Пример:
```sh
schema.contains("wh").isValid("what does the fox say"); // true
```
Для проверки чисел создаем схему:
```sh
NumberSchema schema = v.number();
```
Схема содержит такой набор методов:
required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
positive() — добавляет ограничение на знак числа. Число должно быть положительным
range() — добавляет допустимый диапазон, в который должно попадать значение числа включая границы
Пример:
```sh
schema.range(5, 10);
schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```
Для проверки карт создаем схему:
```sh
MapSchema schema = v.map();
```
Схема содержит следующие методы:
required() — добавляет в схему ограничение, которое не позволяет использовать null в качестве значения. Требуется тип данных Map
sizeof() — добавляет ограничение на размер словаря. Количество пар ключ-значений в объекте Map должно быть равно заданному
shape() используется для определения свойств объекта Map и создания схемы для валидации их значений.
Каждому свойству привязывается набор ограничений, что позволяет более точно контролировать данные.
При работе со сложными данными бывает нужно проверять не только сам объект Map, но и данные внутри него.

Пример:
```sh
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true
schema.sizeof(2);
schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```
Пример проверки структуры карты:
```sh
// shape позволяет описывать валидацию для значений объекта Map по ключам
Map<String, BaseSchema> schemas = new HashMap<>();

// Определяем схемы валидации для значений свойств "name" и "age"
// Имя должно быть строкой, обязательно для заполнения
schemas.put("name", v.string().required());
// Возраст должен быть положительным числом
schemas.put("age", v.number().positive());
schema.shape(schemas);

// Проверяем объекты
Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null);
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human4); // false
```
