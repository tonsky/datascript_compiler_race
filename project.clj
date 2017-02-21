(defproject datascript "0.15.5"
  :dependencies [
    [org.clojure/clojure "1.9.0-alpha14" :scope "provided"]
    [org.clojure/clojurescript "1.9.473" :scope "provided"]
  ]
  
  :plugins [[lein-cljsbuild "1.1.5"]]
  
  :jvm-opts ["-Xmx2g" "-server"]
  :global-vars  { *print-namespace-maps* false }
  :source-paths ["src"]
)
