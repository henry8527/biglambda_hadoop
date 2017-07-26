for file in benchmarks/*
do
  x=$(echo "$file" | cut -f2 -d"/")
  echo "$x"
  python3 __main__.py -b "$x"
done
