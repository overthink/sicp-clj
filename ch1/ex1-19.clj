; Logarithmic Fibinacci
;
; Had to peek at answer: http://community.schemewiki.org/?sicp-ex-1.19
;
; Question tells us that there is a transformation Tpq(a,b) = (a',b') defined
; like this:
;
; a' = qa + qb + pa
;    = (q + p)a + qb (i)
; b' = qa + pb       (ii)
;
; The want us to apply the transformation twice and express the result "in
; terms of p and q".  I wasn't sure what this was really asking for at first.
; It just means factor out a and b. i.e. we want to come up with equations that
; look like this:
;
; a'' = (__ + __)a + (__)b
; b'' = (__)a + (__)b
;
; Whatever ends up in these empty spots will be our transformed p and q: p' and
; q'.  So we just need to apply the given transformation twice, expand
; everything, then write each equation down with a and b factored out.
;
; a' and b' are given above.
;
; a'' = (q + p)a' + qb'
;     = (q + p)((q + p)a + qb) + q(qa + pb)
;     = (q + p)aq + q^2b + (q + p)ap + bpq + aq^2 + bpq
;     = aq^2 + apq + bq^2 + apq + ap^2 + bpq + aq^2 + bpq
;     = 2aq^2 + 2apq + ap^2 + bq^2 + 2bpq
;     = (2q^2 + 2pq + p^2)a + (q^2 + 2pq)b
;        ^^^ p' + q' ^^^^      ^^ q' ^^^  by (i) above
;
; b'' = qa' + pb'
;     = q((q + p)a + qb) + p(qa + pb)
;     = aq(q + p) + bq^2 + apq + bp^2
;     = aq^2 + apq + bq^2 + apq + bp^2
;     = (q^2 + 2pq)a + (q^2 + p^2)b
;        ^^ q' ^^^      ^^^ p' ^^     by (ii) above
;
; The result of b'' actually gives the full answer, and fortunately a'' agrees :)
; p' = q^2 + p^2
; q' = q^2 + 2pq
;
;
; This algorithm is extremely efficient.  Possibly the most efficient?  It's
; Dijkstra's.  Various links and discussion here:
; http://www.reddit.com/r/programming/comments/2mzy3/ask_reddit_whats_the_fastest_fibonacci_algorithm
;
; Example: 20 millionth Fibonacci number: 10 minutes.  This is a number with 4179753 digits.
; user=> (time (def x (fib 20000000)))
; "Elapsed time: 567412.85168 msecs"

(defn square [x] (* x x))

(defn fib-iter [a b p q thecount]
  (cond 
    (zero? thecount) b
    (even? thecount) 
      (recur a 
             b 
             (+ (square p) (square q)) ; p'
             (+ (square q) (* 2 p q))  ; q'
             (/ thecount 2))
    :else
      (recur (+ (* b q) (* a q) (* a p))
             (+ (* b p) (* a q))
             p
             q
             (dec thecount))))

(defn fib [n]
  (fib-iter 1 0 0 1 n))

