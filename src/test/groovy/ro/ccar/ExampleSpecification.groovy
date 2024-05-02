package ro.ccar

import spock.lang.Specification
import spock.lang.Subject

class ExampleSpecification extends Specification {

//    void setupSpec() {
        // setup code that needs to be run once at the start of the specification
//    }


//    void setup() {
        // Here we perform any setup needed before a test is run.
        // This is an implicit block, with code not in any block at all becoming part of it
//    }


//    void cleanup() {
        // Here we tear down any test dependency resources which would otherwise be left behind.
        // For example, we might want to remove any files from the file system or remove test data written to a database
//    }

//    void cleanupSpec() {
        // code that tears down everything at the end when all tests have run
//    }

    def "should be a simple assertion"() {
        // This is a way of performing our stimulus and assertion within the same block.
        // Depending on what we find more expressive, we may or may not choose to use this block
        expect:
        1 == 1
    }

    def "should demonstrate given-when-then"() {
        // Here we perform any setup needed before a test is run.
        given:
        def polygon = new Polygon(4)

        // This is where we provide a stimulus to what is under test. In other words, where we invoke our method under test.
        when:
        int sides = polygon.numberOfSides

        // This is where the assertions belong. In Spock, these are evaluated as plain boolean assertions, which will be covered later
        then:
        sides == 4
    }

    def "should expect Exceptions"() {
        when:
        new Polygon(0)

        then:
        def exception = thrown(TooFewSidesException)
        "It cannot have less than 3 sides" == exception.message
    }

    def "should expect an Exception to be thrown for a number of invalid inputs: #sides"() {
        when:
        new Polygon(sides as int)

        then:
        def exception = thrown(TooFewSidesException)
        "It cannot have less than 3 sides" == exception.message

        // specifies input values for the test
        where:
        sides << [-1, 0, 1, 2]
    }

    def "should be able to create a polygon with #sides sides"() {
        expect:
        new Polygon(sides as int).numberOfSides == sides

        where:
        sides << [3, 4, 5, 8, 14]
    }

    def "should use data tables for calculating max. Max of #a and #b is #max"() {
        expect:
        Math.max(a, b) == max

        where:
        a | b || max
        1 | 3 || 3
        5 | 3 || 5
        1 | 2 || 2
        3 | 3 || 3
    }

    def "should be able to mock a concrete class"() {
        given:
        Renderer renderer = Mock()

        @Subject
        def polygon = new Polygon(6, renderer)

        when:
        polygon.draw()

        then:
        6 * renderer.drawLine(_)
    }

    def "should be able to create a stub"() {
        given: "a palette with red as the primary colour"
        Palette palette = Stub()
        palette.primaryColour >> Colour.RED

        and: "a renderer initialized with the red palette"
        @Subject
        def renderer = new Renderer(palette)

        expect:
        renderer.getForegroundColour() == Colour.RED
    }

    def "should be able to create a stub - using given-when-then"() {
        given:
        Palette palette = Stub()
        palette.primaryColour >> Colour.RED

        @Subject
        def renderer = new Renderer(palette)

        when:
        renderer.getForegroundColour()

        then:
        Colour.RED
    }

}
