(ns clojure-tic-tac-toe.move-validation
  (:require [clojure-tic-tac-toe.board :as board]))

(defn valid-move? [board move]
  (not (empty? (filter (fn [cell] (= move cell)) (board/available-spaces board)))))
