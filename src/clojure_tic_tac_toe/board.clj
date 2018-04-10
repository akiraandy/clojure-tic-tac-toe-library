(ns clojure-tic-tac-toe.board)

(defn get-board [board-vector] 
  board-vector)

(defn- is-empty? [space]
  (number? space))

(defn available-spaces [board] 
  (filter #(is-empty? %) board))

(defn fill-board [board index marker]
  (assoc board index marker))

(defn full? [board]
  (empty? (available-spaces board)))
