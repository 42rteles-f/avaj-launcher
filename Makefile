NAME = app.Main
SCENARIO = scenario.txt

all:
	find src -name "*.java" > sources.txt
	javac @sources.txt

run: all
	java -cp src $(NAME) $(SCENARIO)
	cat simulation.txt

clean:
	find src -name "*.class" -delete
	rm -f sources.txt

re: clean all

.PHONY: all run clean