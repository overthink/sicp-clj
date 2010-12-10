; ---
; Induction Refresher (from: http://www.analyzemath.com/math_induction/mathematical_induction.html)
; Prove 3^n > n^2, for all n >= 1
; Step 1: base case
; For n = 1, 3^1 > 1^2
;              3 > 1 - ok
;
; Step 2: inductive hypothesis
; Assume true when n=k
; 3^k > k^2 
;
; Step 3: prove true for n = k+1
;
; Prove: 3^(k+1) > (k+1)^2
;
; 3^k > k^2 (assumed)
; 3^k * 3 > k^2 * 3 (mult. both sides by 3)
; 3^(k+1) > 3k^2 (i)
;
; Indepent of this problem, notice that for a number k > 2 we can write:
; 1 < k^2   (obvious)
; 2k < k^2  (divide each side by k to see why it's obvious for k > 2)
; Now combine these two inequalities by adding their LHS' and RHS':
; 2k + 1 < 2k^2
; k^2 + 2k + 1 < k^2 + 2k^2 (add k^2 to both sides)
; k^2 + 2k + 1 < 3k^2
; (k + 1)^2 < 3k^2 (factor LHS)
; 3k^2 > (k+1)^2 (ii)
;
; 3^(k+1) > 3k^2           by (i)
;           3k^2 > (k+1)^2 by (ii)
; So:
; 3^(k+1) > (k+1)^2 (by transitivity of >)
;
; Which proves our step 3.
; ---
;
; Onward...
;
; lowercase phi φ - <ctrl-k>f*
; lowercase psi ψ - <ctrl-k>q*
; square root √ - <ctrl-k>RT
; squared ² - <ctrl-k>2S
;
; I found this difficult... here's a good solution I worked from:
; http://www.billthelizard.com/2009/12/sicp-exercise-113-fibonacci-and-golden.html
;
;
; Prove that Fib(n) is the closest integer to φ^n/√5, where φ = (1+√5)/2.
; Hint:
;   Let ψ = (1-√5)/2
;   Prove that Fib(n) = (φ^n-ψ^n)/√5
;
; Note: φ has some interesting properties:
; φ² = φ + 1   (i)
; 1/φ + 1 = φ  (ii)
;
; The hint gives us a related constant ψ = (1-√5)/2 with the same interesting props:
; ψ² = ψ + 1   (iii)
; 1/ψ + 1 = ψ  (iv)
;
; Recall:
; Fib(n) = 0 if n = 0
;          1 if n = 1
;          Fib(n-1) + Fib(n-2) if n > 1
;
; Rewritten since we know 'n+1' is important in inductive proofs:
; Fib(n+1) = Fib(n) + Fib(n-1) for n > 0 
;
; Step 1: Show that it works for n=[0,1,2]
;
; n = 0
; Fib(0) = (φ^0 - ψ^0)/√5
;      0 = (1 - 1)/√5
;      0 = 0
;      good
;
; n = 1
; Fib(1) = (φ^1 - ψ^1)/√5
;      0 = (φ - ψ)/√5
;      0 = (1/2 + √5/2 - 1/2 - √5/2)/√5
;      0 = 0 
;      good
;
; n = 2
; Fib(2) = (φ^2 - ψ^2)/√5
;      1 = ((φ + 1) - (ψ + 1)) / √5  (by (i) and (iii) above)
;      1 = ((φ + 1) - (ψ + 1)) / √5
;      1 = (((1+√5)/2 + 1) - ((1-√5)/2) + 1)) / √5
;      1 = ((1+√5)/2 + 1 - (1-√5)/2 - 1) / √5
;      1 = ((1+√5)/2 - (1-√5/2)) / √5
;      1 = ((1+√5) - (1-√5)) / 2 / √5
;      1 = (1 + √5 - 1 + √5) / 2 / √5
;      1 = (2√5) / 2 / √5
;      1 = 1
;      good
;
; Recall we want to show:
; Fib(n+1) = Fib(n) + Fib(n-1) for n > 0 
;
; Step 3:
; Assuming:
;   Fib(n) = (φ^n - ψ^n) / √5
;   Fib(n-1) = (φ^(n-1) - ψ^(n-1)) / √5
; Does it follow that:
;   Fib(n+1) = (φ^(n+1) - ψ^(n+1)) / √5
;
; Fib(n+1) = Fib(n) + Fib(n-1)
;          = [(φ^n - ψ^n) / √5] + [(φ^(n-1) - ψ^(n-1)) / √5]
;          = (φ^n - ψ^n) + (φ^(n-1) - ψ^(n-1)) / √5
;          = (φ^n - ψ^n + φ^(n-1) - ψ^(n-1)) / √5
;          = (φ^n + φ^(n-1) - ψ^n - ψ^(n-1)) / √5
;          = ((φ^n + φ^(n-1)) - (ψ^n + ψ^(n-1))) / √5
;          = (φ^(n+1) * (φ^-1 + φ^-2) - ψ^(n+1) * (ψ^-1 + ψ^-2)) / √5
;          = (φ^(n+1) * (φ^-1) * (1 + φ^-1) - ψ^(n+1) * (ψ^-1) * (1 + ψ^-1)) / √5
;          = (φ^(n+1) * 1/φ * (1 + 1/φ) - ψ^(n+1) * (1/ψ) * (1 + 1/ψ)) / √5
;          = (φ^(n+1) * 1/φ * (φ) - ψ^(n+1) * (1/ψ) * (ψ)) / √5  (by (ii) and (iv) above)
;          = (φ^(n+1) - ψ^(n+1)) / √5 
;          QED
;
; So we proved the hint, but how does this equate back to "Fib(n) is the
; closest integer to φ^n/√5".  What does "n is the closest int to x" mean?
; Well, the furthest x could be from a nearby integer n is 1, and the closest
; it could be is 0 (if x == n).  So as long as x is strictly less than 1/2 away
; from n, it's the closest integer.  If it was exactly 1/2 away, it would be
; equally close to n+1.  If it was more than 1/2 away, it would actually be
; closer to n+1.
;
; So for our problem we want to prove that the difference between Fib(n) and (φ^n - ψ^n) / √5 is < 1/2.
; 
; Fib(n) = (φ^n - ψ^n) / √5
; Fib(n) = φ^n/√5 - ψ^n/√5 (expand)
; Fib(n) - φ^n/√5 = ψ^n/√5 (rearrange)
;
; The LHS here is the difference we care about, so we just tneed to prove
;
; ψ^n/√5 <= 1/2
; ψ^n <= √5/2 (v)
;
; Note: you can just evaluate ψ.  It equals approx -0.618
; For Fib(n), n is always an integer and n >= 0... so
;
; Since ψ < 1 and n >= 0, then ψ^n <= 1 (decimal num k between 0 and 1 is k=1/x, so k^n can never exceed 1)
;
; You can also evaluate √5/2 = 1.118
;
; √5/2 > 1 
; ψ^n <= 1
; So:
; ψ^n <= √5/2 
; QED (proves (v), meaning Fib(n) is the closest integer to φ^n/√5)
;
; Good times :)
;
