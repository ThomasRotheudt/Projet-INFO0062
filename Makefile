clean:
	# delete all .class files in the current directory and subdirectories
	find . -type f -name "*.class" -exec rm -f {} \;
	clear

archive:
	tar -czvf Rotheudt_Thomas.tar.gz  AdventureGame.java game player world Makefile