CC = javac
INT = java
SOURCES := *.java
CLASSDIR := cls
OPTS = -Xlint:deprecation -Xlint:unchecked
CLASS := main
INPUT := test.txt
.PHONY: clean

all:
make clean && make build && make run

build:

$(CC) -d $(CLASSDIR) $(SOURCES) $(OPTS)

prod:
$(CC) $(CLASSDIR) $(SOURCES)

run:
$(INT) -classpath $(CLASSDIR) $(CLASS) $(INPUT)

clean:
rm -f $(CLASSDIR)/*.class
