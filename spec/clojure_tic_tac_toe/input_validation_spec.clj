(ns clojure-tic-tac-toe.input-validation-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.input-validation :refer :all]))

(describe "input-validation"
  (describe "is-number?"
    (it "should return true if input is a number"
      (should= true (is-number? "4")))
    (it "should return false if input is not a number"
    (should= false (is-number? "h")))
      (it "should return false if input is empty"
        (should= false (is-number? "")))))
