This repo demonstrates race condition in ClojureScript compiler:

```sh
git clone https://github.com/tonsky/datascript_compiler_race.git
cd datascript_compiler_race
lein do clean, run -m datascript.build
```

As this is race condition, it might not reproduce perfectly every time.

Examples of what I get on my MacBook Pro Retina Mid 2012 (Core i7-3615QM, 4 cores):

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build
WARNING: parse-binding at line 215 is being replaced at line 215 src/datascript/parser.cljc
WARNING: collect-vars-acc at line 470 is being replaced at line 470 /Users/prokopov/datascript/src/datascript/parser.cljc
Feb 21, 2017 1:07:13 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/target/datascript/parser.js:140: ERROR - Parse error. Semi-colon expected
datascript.parser.collect.cljsdatascript.parser.collect.cljs$lang$mavar G__16546 = cljs.datascript.parser.collvar seq16545__$1 = cljs.core.next(seq16545);
                                                                        ^

Feb 21, 2017 1:07:13 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/target/datascript/parser.js:1676: ERROR - Parse error. IE8 (and below) will parse trailing commas in array and object literals incorrectly. If you are targeting newer versions of JS, set the appropriate language_in option.
return faif(cljs.coredatascript.parser.RuleVars.prototype.cljs$core$IMap$_dissoc$arity$2 = (function (this__7667__auto__,k__7668return ((this__7654__auto____$1.constructor === other__7655__autoif(cljs.core.contains_QMARK_(new cljs.core.PersistentHashSet(null, new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$free,return true;
                                                                                                                                                                                                                                                                                                                                    ^

Feb 21, 2017 1:07:13 PM com.google.javascript.jscomp.LoggerErrorManager printSummary
WARNING: 2 error(s), 0 warning(s)
ERROR: JSC_PARSE_ERROR. Parse error. Semi-colon expected at /Users/prokopov/datascript/target/datascript/parser.js line 140 : 72
ERROR: JSC_TRAILING_COMMA. Parse error. IE8 (and below) will parse trailing commas in array and object literals incorrectly. If you are targeting newer versions of JS, set the appropriate language_in option. at /Users/prokopov/datascript/target/datascript/parser.js line 1676 : 324
```

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build
WARNING: parse-binding at line 215 is being replaced at line 215 src/datascript/parser.cljc
WARNING: parse-clause at line 598 is being replaced at line 598 /Users/prokopov/datascript/src/datascript/parser.cljc
WARNING: parse-clauses at line 611 is being replaced at line 611 /Users/prokopov/datascript/src/datascript/parser.cljc
Feb 21, 2017 1:05:50 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/target/datascript/parser.js:458: ERROR - Parse error. Semi-colon expected
datasreturn cljs.core.pr_sequential_writer(writer__7673__auto__,pr_pair__7675__auto__,"#datascript.parser.Variable{",", ","}",opts__7674__auto__,cljs.core.concat.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentVector(null, 1, 5return (new cljs.core.RecordIter((0),G__16721__$1,1,new cljs.core.PersistentVector(null, 1, 5, cljs.core.PersistentVector.EMPTY_NODE, [cljs.core.cst$kw$symbol], null),(cljs.core.truth_(self__.__extmap)?cljs.core._iterator(self__.__extmap):cljs.core.nil_iter())));
            ^

Feb 21, 2017 1:05:50 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/target/datascript/parser.js:4080: ERROR - Parse error. IE8 (and below) will parse trailing commas in array and object literals incorrectly. If you are targeting newer versions of JS, set the appropriate language_in option.
throw cljs.core.ex_info.cljs$core$IFn$_invoke$arity$2([cljs.core.str.cljs$cothrow cljs.core.ex_info.cljs$core$IFn$_invoke$arity$2([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Cannot parse pull expression, expect ['pull' src-var? variable (constant | variable | plain-symbol)]")].join(''),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$error,}
                                                                                                                                                                                                                                                                                                                                                                  ^

Feb 21, 2017 1:05:50 PM com.google.javascript.jscomp.LoggerErrorManager printSummary
WARNING: 2 error(s), 0 warning(s)
ERROR: JSC_PARSE_ERROR. Parse error. Semi-colon expected at /Users/prokopov/datascript/target/datascript/parser.js line 458 : 12
ERROR: JSC_TRAILING_COMMA. Parse error. IE8 (and below) will parse trailing commas in array and object literals incorrectly. If you are targeting newer versions of JS, set the appropriate language_in option. at /Users/prokopov/datascript/target/datascript/parser.js line 4080 : 354
```

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build
WARNING: parse-binding at line 215 is being replaced at line 215 /Users/prokopov/datascript/src/datascript/parser.cljc
Feb 21, 2017 1:02:55 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/target/datascript/parser.js:4507: ERROR - Parse error. ',' expected
throw cljs.core.ex_info.cljs$core$IFn$_invoke$arity$2([cljs.core.str.cljs$core$IFn$_invoke$arity$1("Cannot parse :find, expected: (find-rel | find-coll | find-tuple | find-scalar)")].join(''),new cljs.core.PersistentArrayMap(null, 2, [cljs.core.cst$kw$error,cljs.core.cst$kw$parser_SLASH_find,cljs.core.cst$kw$fragment,forvar or__6983__}
                                                                                                                                                                                                                                                                                                                                      ^

Feb 21, 2017 1:02:55 PM com.google.javascript.jscomp.LoggerErrorManager printSummary
WARNING: 1 error(s), 0 warning(s)
ERROR: JSC_PARSE_ERROR. Parse error. ',' expected at /Users/prokopov/datascript/target/datascript/parser.js line 4507 : 326
```

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build
WARNING: collect-vars-acc at line 470 is being replaced at line 470 src/datascript/parser.cljc
WARNING: parse-clause at line 598 is being replaced at line 598 src/datascript/parser.cljc
WARNING: parse-clauses at line 611 is being replaced at line 611 src/datascript/parser.cljc
Feb 21, 2017 1:02:00 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/target/datascript/parser.js:227: ERROR - Parse error. ',' expected
this.datascript.parser.Placeholder.prototype.cljs$core$ILookup$_lookup$arity$2 = (function (this__7658_this.cljs$lang$protocol_mask$partition1$ = 81var thidatascript.parser.Placeholdereturn this__7658__auto____$1.cljs$core$ILookup$_lookup$arity$3(null,k__7659__auto__,null);
                                                                                                           ^

Feb 21, 2017 1:02:00 PM com.google.javascript.jscomp.LoggerErrorManager printSummary
WARNING: 1 error(s), 0 warning(s)
ERROR: JSC_PARSE_ERROR. Parse error. ',' expected at /Users/prokopov/datascript/target/datascript/parser.js line 227 : 107
```

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build
WARNING: parse-binding at line 215 is being replaced at line 215 /Users/prokopov/datascript/src/datascript/parser.cljc
Feb 21, 2017 1:00:46 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/out/datascript/parser.js:215: ERROR - Parse error. Character '@' (U+0040) is not a valid identifier start char
datascript.parser.Placeholder = (functio * @implements {cljs.core.IAthis.__meta  * @implemthis.__extmap = __extm * @this.__hash = __hash;
                                           ^

Feb 21, 2017 1:00:46 PM com.google.javascript.jscomp.LoggerErrorManager printSummary
WARNING: 1 error(s), 0 warning(s)
ERROR: JSC_PARSE_ERROR. Parse error. Character '@' (U+0040) is not a valid identifier start char at /Users/prokopov/datascript/out/datascript/parser.js line 215 : 43
```

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build
WARNING: collect-vars-acc at line 470 is being replaced at line 470 /Users/prokopov/datascript/src/datascript/parser.cljc
WARNING: parse-clause at line 598 is being replaced at line 598 /Users/prokopov/datascript/src/datascript/parser.cljc
WARNING: parse-clauses at line 611 is being replaced at line 611 /Users/prokopov/datascript/src/datascript/parser.cljc
Feb 21, 2017 12:59:33 PM com.google.javascript.jscomp.LoggerErrorManager println
SEVERE: /Users/prokopov/datascript/out/datascript/parser.js:7639: ERROR - Parse error. '}' expected

Feb 21, 2017 12:59:33 PM com.google.javascript.jscomp.LoggerErrorManager printSummary
WARNING: 1 error(s), 0 warning(s)
ERROR: JSC_PARSE_ERROR. Parse error. '}' expected at /Users/prokopov/datascript/out/datascript/parser.js line 7639 : 0
```

Note how output JS is not even syntatically correct:

```
functio * @implements
```

```
__meta  * @implemthis.__extmap
```

```
,forvar or__6983__}
```

This is a clear sign that two or more threads are writing to the same file without coordination.

Also note that with parallel build enabled, compiler confuses `declare` with function defenition and warns about `collect-vars-acc at line 470 is being replaced at line 470`. In fact, the function is definen just once, it is just declared a little earlier in the file with `declare`

Also note that setting `:parallel-build false` leads to 100% stable, error-less builds:

```
[~/datascript_compiler_race] lein do clean, run -m datascript.build --no-parallel
[~/datascript_compiler_race] 
```
