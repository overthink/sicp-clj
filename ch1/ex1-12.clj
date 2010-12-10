; Pascal's triangle
; (Ingoring any knowledge of binomial theorem.)
;
;   k 0 1 2  3 4 5
; n +---------------
; 0 | 1
; 1 | 1 1
; 2 | 1 2 1
; 3 | 1 3 3  1
; 4 | 1 4 6  4  1
; 5 | 1 5 10 10 5 1
; ...
;
; Each row n has n+1 numbers
; let f(n, k) be the value of number in position k in row n
; f(n, x) = 1 if n < 2
;         = 1 if k = 0
;         = 1 if k = n
;         = f(n-1, k) + f(n-1, k-1)

(defn pascal [n k]
  "Calculate the kth number in the nth row of Pascal's triangle."
  (cond
    (> k n) (throw (Exception. "n cannot be greater than k"))
    (< n 2) 1
    (zero? k) 1
    (= k n) 1
    :else (+ (pascal (dec n) k) (pascal (dec n) (dec k)))))

(defn pascals-triangle [num-rows]
  "Generate the first num-rows rows of Pascal's triangle."
  (map-indexed 
    (fn [n k] (map #(pascal n %) k)) 
    (map #(range 0 (inc %)) (range 0 num-rows))))

(defn print-triangle [num-rows]
  "Helper to print out the triangle."
  (doseq [row (pascals-triangle num-rows)] (println row)))

; This one was fun!

