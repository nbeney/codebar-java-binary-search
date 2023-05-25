# codebar-java-binary-search

A sample repo with:
* Java implemementation ([iterative and recursive](https://www.advanced-ict.info/programming/recursion.html#:~:text=Iteration%20and%20recursion%20are%20key,again%20to%20repeat%20the%20code.)) of the [binary search algorithm](https://en.wikipedia.org/wiki/Binary_search_algorithm) with [generic methods](https://docs.oracle.com/javase/tutorial/extra/generics/methods.html).
* [JUnit5](https://junit.org/junit5/) [parameterized](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests) unit tests with [@CsvSource](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-CsvSource) and [@CsvFileSource](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-sources-CsvFileSource).
* [Maven](https://maven.apache.org/) [pom.xml](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) build file with [Surefire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/) to run the unit tests.
* [GitHub Action](https://docs.github.com/en/actions/learn-github-actions) to [build and test Java with Maven](https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-maven) on every commit.
