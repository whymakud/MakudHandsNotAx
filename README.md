# MakudHandsNotAx
Плагин, наносящий урон игроку, когда он ломает дерево руками.

Функционал:
- **Настройка сообщений.**
- **Настройка наносимого урона.**
- **Настройка списка топоров для новых версий.**

Команды и права:
- Команда: _/makudhandsnotax reload_
- Право: _makudhandsnotax.reload_

Настройка:

```
damage: # Сколько урона получит игрок
  min: 5 # Минимальное значение урона
  max: 6 # Максимальное значение урона

# Сообщения
# Чтобы отключить сообщения - message: null
# Писать в одну строчку можно так - message: "Текст"
message:
  - "&cСкрафти топор, а то так и"
  - "&7будешь получать урон если будешь"
  - "&7ломать руками"

axe-list: # Список топоров
  - wooden_axe
  - stone_axe
  - golden_axe
  - iron_axe
  - diamond_axe
# - netherite_axe (только на новых версиях)
```

Если вам лень _скомпилировать плагин_, скачайте из релизов.
