# Программа обработки чисел

Этот проект содержит Java-программу, которая **читает числа из файла** и выполняет различные операции над ними, такие как нахождение минимального и максимального числа, вычисление суммы и произведения.

## Описание функций

- **_min**: Находит минимальное число в списке.
- **_max**: Находит максимальное число в списке.
- **_sum**: Считает сумму всех чисел в списке.
- **_mult**: Считает произведение всех чисел в списке.

## Требования к файлу

- Числа должны быть записаны в одной строке, разделены пробелами.
- В файле должно быть как минимум одно число.
- Максимально возможное количество чисел в файле — 1 млн.

## Пример работы

В файле `numbers.txt`:

```
1 4 2 3
```

Результаты:
- **Минимальное число**: 1
- **Максимальное число**: 4
- **Сумма**: 10
- **Произведение**: 24

## Запуск проекта

### Скачивание проекта

Клонируйте репозиторий на ваш локальный компьютер с помощью следующей команды:

```bash
git clone [URL-репозитория]
```

### Компиляция и запуск

Перейдите в каталог проекта и скомпилируйте Java-классы:

```bash
cd [путь-к-проекту]/src/main/java
javac org/example/NumberProcessor.java
```

Запустите программу из директории `src`, указав путь к файлу с данными:

```bash
cd ../../..
java -cp ./main/java org.example.NumberProcessor ./main/resources/negative.txt
```

### Использование тестов

В директории `src/main/resources` вы найдете предустановленные файлы для тестирования:

- `empty.txt` — пустой файл для тестирования обработки пустого списка.
- `negative.txt` — файл с отрицательными числами.
- `numbers.txt` — файл с примерными числами для расчета.

Вы можете использовать эти файлы для запуска программы или добавить свой файл с данными в эту же директорию.

### Примеры запуска

Запуск программы с файлом отрицательных чисел:

```bash
java -cp ./main/java org.example.NumberProcessor ./main/resources/negative.txt
```

## Тестирование

В директории `src/main/java/org/example` вы найдете класс `NumberProcessorTest.java`, который содержит юнит-тесты для проверки функциональности программы.

![Java CI](https://github.com/maybebbaby/TZ_2/actions/workflows/java-ci.yml/badge.svg)

## Уведомления в Telegram через GitHub Actions

### Обзор
Этот проект настроен на использование Telegram бота для отправки уведомлений о результатах сборок CI. Уведомления включают детализированные отчеты о неудачных тестах.

### Настройка Telegram бота

1. **Создайте Telegram бота**:
   - Откройте Telegram и найдите `BotFather`.
   - Начните чат с `BotFather` и создайте нового бота с помощью команды `/newbot`.
   - Следуйте инструкциям для задания имени и имени пользователя для вашего бота.
   - После создания бота `BotFather` предоставит вам API токен. Сохраните этот токен.

2. **Получите Chat ID**:
   - Добавьте бота в группу Telegram или начните с ним личный чат.
   - Отправьте сообщение в чат, куда вы хотите получать уведомления.
   - В веб-браузере откройте `https://api.telegram.org/bot<YourBOTToken>/getUpdates`, заменив `<YourBOTToken>` на API токен вашего бота.
   - Найдите объект `chat` в JSON ответе, чтобы получить `chat_id`.

### Настройка GitHub Actions

1. **Добавьте секреты в GitHub**:
   - Перейдите в настройки вашего репозитория GitHub, затем в `Settings` -> `Secrets and variables` -> `Actions`.
   - Нажмите `New repository secret` и добавьте следующие секреты:
     - `TELEGRAM_TOKEN`: API токен вашего Telegram бота.
     - `TELEGRAM_CHAT_ID`: Chat ID, куда вы хотите получать уведомления.

2. **Настройка workflow GitHub Actions**:
   - Убедитесь, что ваш файл `.github/workflows/java-ci.yml` настроен для отправки уведомлений с использованием Telegram бота. Workflow должен включать шаги для:
     - Настройки окружения проекта (например, checkout кода, настройка JDK).
     - Сборки проекта и запуска тестов.
     - Захвата результатов тестов, особенно при неудачах.
     - Отправки детализированных уведомлений через Telegram, включая сводку по неудачным тестам.

### Использование
После настройки ваш Telegram бот будет отправлять уведомления:
- **Все ок**: Сообщение, указывающее, что все тесты прошли успешно.
- **Некоторые тесты не пройдены. См. подробности**: Сообщение с отчетом о неудачных тестах, включая названия тестов и сообщения об ошибках.
