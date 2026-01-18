NAME = app.Main
SCENARIO = scenario.txt
SIMULATION_OUTPUT = simulation.txt

all:
	find src -name "*.java" > sources.txt
	javac @sources.txt

run: all
	java -cp src $(NAME) $(SCENARIO)
	cat $(SIMULATION_OUTPUT)

clean:
	find src -name "*.class" -delete
	rm -f sources.txt
	rm -f $(SIMULATION_OUTPUT)

re: clean all

.PHONY: all run clean