# Maartens Micro-Benchmarks

[![CircleCI](https://circleci.com/gh/mthmulders/micro-benchmarks/tree/master.svg?style=svg)](https://circleci.com/gh/mthmulders/micro-benchmarks/tree/master)
[![Dependabot](https://flat.badgen.net/dependabot/thepracticaldev/dev.to?icon=dependabot)](https://app.dependabot.com/)

This repository contains a collection of so-called "micro-benchmarks".
A micro-benchmark is a tool that measures performance characteristics of a small piece of code.

I publish them mainly to be of inspiration to others, and optionally to be able to refer to them in conversations I have.

Please keep in mind that you should never blindly make decisions on the outcome of any micro-benchmark.
The data they produce may be skewed by many, many factors.
Brian Goetz summarises this nicely:

> You're not always measuring what you think you're measuring. 
>
> &mdash; <cite>Brian Goetz, [Dynamic compilation and performance measurement](https://www.ibm.com/developerworks/java/library/j-jtp12214/)</cite>

## Micro-Benchmark Index

The collection currently contains the following micro-benchmarks:

1. [different approaches to doing String concatenation](src/main/java/it/mulders/junk/StringFormatting.java)

## Implementation

All micro-benchmarks are implemented with [JMH](https://openjdk.java.net/projects/code-tools/jmh/).
JMH provides a harness for building, running, and analysing micro-benchmarks written in Java and other JVM-languages.
Build the benchmarks by invoking `mvn package`.
Run them by issuing `java -jar target/benchmark.jar`.
Add `-h` to see a full list of all supported command-line switches.
