(ns clojure-tic-tac-toe.rules
  (:require [clojure-tic-tac-toe.board :as board]))

(defn- combos [board]
  [
   (hash-set (get board 0) (get board 1) (get board 2))
   (hash-set (get board 3) (get board 4) (get board 5))
   (hash-set (get board 6) (get board 7) (get board 8))
   (hash-set (get board 0) (get board 3) (get board 6))
   (hash-set (get board 1) (get board 4) (get board 7))
   (hash-set (get board 2) (get board 5) (get board 8))
   (hash-set (get board 0) (get board 4) (get board 8))
   (hash-set (get board 2) (get board 4) (get board 6))
   ])

(defn- win-on-any? [board]
  (some #(= 1 (count %)) (combos board)))

(defn winner? [board]
  (if(win-on-any? board)
    true
    false))

(defn tie? [board]
 (and (board/full? board) (not(winner? board))))

(defn get-winner [board]
  (let [winner (filter (fn [win-combos] (= 1 (count win-combos))) (combos board))]
    (if (not(empty? winner))
      (get (first winner) :x :o))))

(defn game-over? [board]
  (or(winner? board)(tie? board)))
