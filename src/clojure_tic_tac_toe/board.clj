(ns clojure-tic-tac-toe.board)

(defn get-board [board-vector] 
  board-vector)

(defn- is-empty? [space]
  (number? space))

(defn available-spaces [board] 
  (filter #(is-empty? %) board))

(defn fill-board [index board marker]
  (assoc board index marker))

(defn full? [board]
  (empty? (available-spaces board)))

(defn board-empty? [board]
  (= (count board) (count (available-spaces board))))

(defn middle-available? [board]
  (is-empty? (nth board 4)))
