(ns datascript.build
  (:require
    [cljs.build.api :as b]))


(defn -main [& args]
  (b/build 
    (b/inputs "src")
    { :output-to      "target/datascript.js"
      :output-dir     "target"
      :optimizations  :advanced
      :pretty-print   true
      :parallel-build true
      :elide-asserts true
      :output-wrapper false }))
 
