# Текстовый квест


## Конфигурация Tomcat:
version: 10.1.11

Server -> URL: http://localhost:8080/

Deployment -> Application context: "/"

## Шаблон .json файла:
* *нумерация квестов начинается с 1, далее - в произвольном порядке*

* *поле nextQuestionId каждого ответа на вопрос должен ссылаться на следующий вопрос*

* *вопросы без списка ответов - финальные*
```
[
    {
        "id": 1, 
        "text": "ты потерял память. принять вызов НЛО?",
        "imagePath": "/img/wood.jpg",
        "answers":  
            [
                {
                    "nextQuestionId": 5,
                    "text": "принять"
                },
                {
                    "nextQuestionId": 10,
                    "text": "отклонить"
                },
                {
                    "nextQuestionId": 1,
                    "text": "что?"
                }
            ]
    },{
        "id": 10, 
        "imagePath": "/img/lose.jpg",
        "text": "ты отклонил вызов. Поражение!",
    },
    {
    ...
    },
    ...
]
```