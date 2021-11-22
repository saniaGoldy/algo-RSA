# algo-RSA
1.Consider two prime numbers p and q.
2.Compute n = p*q
3.Compute ϕ(n) = (p – 1) * (q – 1)
4.Choose e such gcd(e , ϕ(n) ) = 1
5.Calculate d such e*d mod ϕ(n) = 1
6.Public Key {e,n} Private Key {d,n}
7.Cipher text C = Pe mod n where P = plaintext
8.For Decryption D = Dd mod n where D will refund the plaintext.