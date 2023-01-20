# Replace Makefile fullclean
# Call specific clean for each Test
#
#!/bin/bash
#
rm -rf `find . -name "build" -print`
rm -rf `find . -name "output" -print`

find . -maxdepth 1 -type d \( ! -name . \) -exec bash -c "cd '{}'/src && ./clean.sh" \;