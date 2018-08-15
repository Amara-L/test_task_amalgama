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
