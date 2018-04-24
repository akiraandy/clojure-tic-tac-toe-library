(ns clojure-tic-tac-toe.board)

(defn- is-empty? [space]
  (number? space))

(defn available-spaces [board] 
  (filter #(is-empty? %) board))

(defn fill-board [index board marker]
  (if (not(nil? index))
    (assoc board index marker)
    board))

(defn full? [board]
  (empty? (available-spaces board)))

(defn board-empty? [board]
  (= (count board) (count (available-spaces board))))

(defn middle-available? [board]
  (is-empty? (nth board 4)))
