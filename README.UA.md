# algo-RSA
#		Алгоритм роботи програми
1. Виберіть два простих числа p та q
2. Обчисліть n = p*q
3. Обчисліть ϕ(n) = (p – 1) * (q – 1)
4. Виберіть e таке що gcd(e , ϕ(n) ) = 1
5. Обчисліть d таке що e*d mod ϕ(n) = 1
6. Публічний ключ: {e,n}
   Приватний ключ: {d,n}
7. Зашифруйте текст C = Pe mod n , де P = Повідомлення переведене в число за спільним з отримувачем алгоритмом
8. Для розшифровки D = Dd mod n, де D число за яким буде відновлене початкове повідомлення(Принцип переведення символів в числа має буди спільним у обох сторін).