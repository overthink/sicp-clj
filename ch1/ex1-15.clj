(defn cube [x] (* x x x))
(defn p [x] (- (* 3 x) (* 4 (cube x))))
(defn sine [angle]
  (if (not (> (Math/abs angle) 0.1))
    angle
    (p (sine (/ angle 3.0)))))

; Q: How many times is p applied for the angle 12.15?
;
; This one was fairly easy.  Even I got it right away :)
; - each time we recurse, we reduce the angle by a factor of 3 (divide by 3)
; - how many times must we divide 12.15 by 3 until we get 0.1 or less?
; 12.15 / 3^n = 0.1
; 12.15 = 0.1 * 3^n
; 121.5 = 3^n
; log3(121.5) = n
; 4.4 =~ n
;
; Can't recurse 4.4 times, so we must have to recurse 5 times.  So p is applied 5 times on the angle 12.15.
;
; The algorithm is 0Olog(n)) in both number of steps and space required.  Specifically it's O(log3(n)).
;

