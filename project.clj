(defproject clojure-tic-tac-toe "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["lib/argumentParser.jar"]
  :dependencies [[org.clojure/clojure "1.8.0"][speclj "3.3.0"]]
  :plugins [[speclj "3.3.0"]]
  :test-paths ["spec"]
  :main clojure-tic-tac-toe.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
