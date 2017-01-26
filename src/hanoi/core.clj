(ns hanoi.core)

(defn hanoi [n & {src :from dst :to temp :temp}]
  (if (= n 1)
    [[src dst]]

    (concat
     (hanoi (dec n) :from src :to temp :temp dst)
     (hanoi 1 :from src :to dst :temp temp)
     (hanoi (dec n) :from temp :to dst :temp src))))

(defn do-instruction [board [src dst]]
  (-> board
      (update src pop)
      (update dst conj (peek (board src)))))
