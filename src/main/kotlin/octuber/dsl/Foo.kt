package octuber.dsl

@DslMarker
annotation class FooDsl


@FooDsl
class Foo

@FooDsl
class Bar

@FooDsl
class Baz

fun pop() {
    createFoo {
        bar {
            baz {
                //bar { }
            }
        }
    }
}

fun createFoo(block: Foo.() -> Unit): Foo {
    return Foo().apply(block)
}

fun Foo.bar(block: Bar.() -> Unit) {

}

fun Bar.baz(block: Baz.() -> Unit) {

}