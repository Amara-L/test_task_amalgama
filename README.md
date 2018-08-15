# Тестовое задание
#### Тестовое задание должно быть выполнено на языке Java и оформлено в виде работающего приложения. 

> Важное требование – разработать API (прикладной программный интерфейс), с помощью которого прикладные программисты смогут легко решать поставленную задачу в своем коде.

Задается список (до 10 элементов) подмножеств множества вещественных чисел, например:

|   |
| ------ |
| (-∞, x1] U [x2, +∞) |
| (-∞, x1] U [x2, x3] U … U [x4, +∞) |
| [x1, x2] |

#### Требуется решать следующие задачи:
- Для любого заданного числа x возвращать число, принадлежащее пересечению
подмножеств, максимально близкое к x (или само число x, если оно принадлежит
пересечению подмножеств). Решение должно быть максимально эффективно с точки
зрения производительности вычисления, так как будет вызваться очень часто.
- Возвращать пересечение подмножеств в виде списка отрезков и полуинтервалов.

#### Пример:

![Пример](//additionally/test_img.png)

- Для задачи 1, результат должен быть равен X2
- Для задачи 2, результат должен быть равен [X1, X2]

## Jar TestTaskAmalgama

В качестве списка необходимо загрузить файл формата .txt
Значения в интерваллах разделяются ",".
В качестве примера представленны два файла в папке test_intervals.

Файлы должны выводить следующие пересечения:

| Файл tets_interval_1.txt | Файл tets_interval_2.txt |
| ------ | ------ |
| [-35, -25] | [0, 0] |
| [45, 50] | [5, 20] |
|    | [35, 45] |

