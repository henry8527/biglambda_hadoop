def analysis(result_str,PROGRAM_NAME,SIG_path):
	split_result_str = result_str.split(':')
	map_result_str = split_result_str[0]
	reduce_result_str = split_result_str[1]

	mr_program_file = open((PROGRAM_NAME+".java"),"w+",encoding = 'UTF-8')

	# write neccessary java lib
	mr_program_file.write("// Import java standard library\n")
	java_standard_lib = ["lang","util","io","math","net","swing"]

	for append_lib in java_standard_lib:
		mr_program_file.write("import java." + append_lib + ".*;\n")

	# write neccessary apache hadoop lib
	hadoop_lib = ["conf.Configuration","fs.Path","io.IntWritable","io.Text","mapreduce.Job","mapreduce.Mapper","mapreduce.Reducer","mapreduce.lib.input.FileInputFormat","lib.output.FileOutputFormat"]
	mr_program_file.write("// Import hadoop mapreduce library\n")
	for append_lib in hadoop_lib:
		mr_program_file.write("import org.apache.hadoop." + append_lib + ";\n")

	tab = "  "
	left_brackets = 0
	# entry public class
	mr_program_file.write("\npublic class " + PROGRAM_NAME + " {\n\n")
	left_brackets+=1

	# entry map class
	mr_program_file.write(tab * left_brackets + "public static class " + PROGRAM_NAME + "Mapper\n")
	mr_program_file.write(tab * left_brackets + "extends Mapper<Object, Text, Text, IntWritable>{\n\n")
	left_brackets+=1

	# start analysis map lambda function

	execute_sig_file = open("programs/execute_sig.py","r",encoding = 'UTF-8')
	execute_sig_file_func = []
	for execute_sig_search in execute_sig_file.readlines():
		if execute_sig_search.find("def") == 0:
			index = execute_sig_search.index("(")
			execute_sig_file_func.append(execute_sig_search[4:index])

	# write the prototype of sig function into program
	### next checkpoint : complete python to java parse 

	for function_write in execute_sig_file_func:
		mr_program_file.write(tab * left_brackets + "public void " + function_write + "(){\n\n")
		mr_program_file.write(tab * left_brackets + "}\n")


	# entry map class main function
	mr_program_file.write(tab * left_brackets + "public void map(Object key, Text value, Context context) throws IOException, InterruptedException {\n")
	mr_program_file.write(tab * (left_brackets+1) + "// " +map_result_str + "\n")

	# analysis core main lambda
	main_lambda_func = []
	now_index = 0
	while map_result_str.find("λ",now_index) >= 0:
		index_head = map_result_str.index("λ.",now_index)
		index_tail = map_result_str.index("(",now_index+1)
		main_lambda_func.append(map_result_str[index_head + 2:index_tail])
		now_index = index_tail

	marked_Var_index = []
	used_func_record = []
	for main_lambda_func_internal in reversed(main_lambda_func):
		brackets_index = map_result_str.find(main_lambda_func_internal)
		brackets_index += len(main_lambda_func_internal)
		for i in range(1,100):
			if map_result_str[brackets_index:(brackets_index + i)].count("(") == map_result_str[brackets_index:(brackets_index + i)].count(")"):
				if map_result_str[brackets_index:brackets_index + i].find("Var") >= 0 and map_result_str.find("Var") not in marked_Var_index:
					Var_index = map_result_str[brackets_index:brackets_index + i].find("Var")
					mark_index = map_result_str.find("Var")
					marked_Var_index.append(mark_index)
					if map_result_str[Var_index:brackets_index + i].find("String") >= 0:
						mr_program_file.write(tab * (left_brackets + 1) + "String Var = new String();\n")
					elif map_result_str[Var_index:brackets_index + i].find("Int") >= 0:
						mr_program_file.write(tab * (left_brackets + 1) + "Integer Var = new Integer();\n")
					elif reduce_result_str[Var_index:brackets_index + i].find("Log") >= 0:
						mr_program_file.write(tab * (left_brackets + 1) + "Log Var = new Log();\n")	
					after_replace = map_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break

				elif map_result_str[brackets_index:brackets_index + i].find("String") >= 0:
					mr_program_file.write(tab * (left_brackets + 1) + "String Var = new String();\n")
					after_replace = map_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break

				elif map_result_str[brackets_index:brackets_index + i].find("Int") >= 0:
					mr_program_file.write(tab * (left_brackets + 1) + "Integer Var = new Integer();\n")
					after_replace = map_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break
				elif map_result_str[brackets_index:brackets_index + i].find("Log") >= 0:
					mr_program_file.write(tab * (left_brackets + 1) + "Log Var = new Log();\n")
					after_replace = map_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break

				else : 
					after_replace = map_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace)
					break

	mr_program_file.write(tab * left_brackets + "}\n")
	mr_program_file.write(tab * (left_brackets-1) + "}\n")


	########################### map reduce wall

	# entry reduce class
	mr_program_file.write(tab * left_brackets + "public static class " + PROGRAM_NAME + "Reducer\n")
	mr_program_file.write(tab * left_brackets + "extends Reducer<Text,IntWritable,Text,IntWritable>{\n\n")
	left_brackets+=1

	# start analysis reduce lambda function

	execute_sig_file = open("programs/execute_sig.py","r",encoding = 'UTF-8')
	execute_sig_file_func = []
	for execute_sig_search in execute_sig_file.readlines():
		if execute_sig_search.find("def") == 0:
			index = execute_sig_search.index("(")
			execute_sig_file_func.append(execute_sig_search[4:index])

	# write the prototype of sig function into program
	### next checkpoint : complete python to java parse 

	for function_write in execute_sig_file_func:
		mr_program_file.write(tab * left_brackets + "public void " + function_write + "(){\n\n")
		mr_program_file.write(tab * left_brackets + "}\n")


	# entry reduce class main function
	mr_program_file.write(tab * left_brackets + "public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {\n")
	mr_program_file.write(tab * (left_brackets+1) + "// " + reduce_result_str + "\n")
	reduce_result_str = reduce_result_str[2:]

	# analysis core main lambda
	main_lambda_func = []
	now_index = 0
	while reduce_result_str.find("λ",now_index) >= 0:
		index_head = reduce_result_str.index("λ.",now_index)
		index_tail = reduce_result_str.index("(",now_index+1)
		main_lambda_func.append(reduce_result_str[index_head + 2:index_tail])
		now_index = index_tail

	marked_Var_index = []
	used_func_record = []
	for main_lambda_func_internal in reversed(main_lambda_func):
		brackets_index = reduce_result_str.find(main_lambda_func_internal)
		brackets_index += len(main_lambda_func_internal)
		for i in range(1,100):
			if reduce_result_str[brackets_index:(brackets_index + i)].count("(") == reduce_result_str[brackets_index:(brackets_index + i)].count(")"):
				if reduce_result_str[brackets_index:brackets_index + i].find("Var") >= 0 and reduce_result_str.find("Var") not in marked_Var_index:
					Var_index = reduce_result_str[brackets_index:brackets_index + i].find("Var")
					mark_index = reduce_result_str.find("Var")
					marked_Var_index.append(mark_index)
					if reduce_result_str[Var_index:brackets_index + i].find("String") >= 0:
						mr_program_file.write(tab * (left_brackets + 1) + "String Var = new String();\n")
					elif reduce_result_str[Var_index:brackets_index + i].find("Int") >= 0:
						mr_program_file.write(tab * (left_brackets + 1) + "Integer Var = new Integer();\n")
					elif reduce_result_str[Var_index:brackets_index + i].find("Log") >= 0:
						mr_program_file.write(tab * (left_brackets + 1) + "Log Var = new Log();\n")	
					after_replace = reduce_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break

				elif reduce_result_str[brackets_index:brackets_index + i].find("String") >= 0:
					mr_program_file.write(tab * (left_brackets + 1) + "String Var = new String();\n")
					after_replace = reduce_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break

				elif reduce_result_str[brackets_index:brackets_index + i].find("Int") >= 0:
					mr_program_file.write(tab * (left_brackets + 1) + "Integer Var = new Integer();\n")
					after_replace = reduce_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break

				elif map_result_str[brackets_index:brackets_index + i].find("Log") >= 0:
					mr_program_file.write(tab * (left_brackets + 1) + "Log Var = new Log();\n")
					after_replace = map_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace_record)
					break
					
				else : 
					after_replace = reduce_result_str[brackets_index:brackets_index + i].replace("λ.","")
					after_replace_record = after_replace
					for used_func in used_func_record:
						after_replace = after_replace.replace(used_func,"_result")
					mr_program_file.write(tab * (left_brackets + 1) + "while(1) {\n")
					mr_program_file.write(tab * (left_brackets + 2) + main_lambda_func_internal + " " + after_replace + ";\n")
					mr_program_file.write(tab * (left_brackets + 1) + "}\n")
					used_func_record.append(after_replace)
					break

	mr_program_file.write(tab * left_brackets + "}\n")
	mr_program_file.write(tab * (left_brackets-1) + "}\n")
	left_brackets = left_brackets - 1

	################# main function wall

	mr_program_file.write(tab * left_brackets + "public static void main(String[] args) throws Exception {\n")
	left_brackets = left_brackets + 1
	mr_program_file.write(tab * left_brackets + "Configuration conf = new Configuration();\n")
	mr_program_file.write(tab * left_brackets + "Job job = Job.getInstance(conf, "");\n")
	mr_program_file.write(tab * left_brackets + "job.setJarByClass();\n")
	mr_program_file.write(tab * left_brackets + "job.setMapperClass();\n")
	mr_program_file.write(tab * left_brackets + "job.setCombinerClass();\n")
	mr_program_file.write(tab * left_brackets + "job.setReducerClass();\n")
	mr_program_file.write(tab * left_brackets + "job.setOutputKeyClass();\n")
	mr_program_file.write(tab * left_brackets + "job.setOutputValueClass();\n")
	mr_program_file.write(tab * left_brackets + "FileInputFormat.addInputPath(job, new Path(args[0]));\n")
	mr_program_file.write(tab * left_brackets + "FileOutputFormat.setOutputPath(job, new Path(args[1]));\n")
	mr_program_file.write(tab * left_brackets + "System.exit(job.waitForCompletion(true) ? 0 : 1);\n")
	left_brackets = left_brackets - 1
	mr_program_file.write(tab * left_brackets + "}\n")
	left_brackets = left_brackets - 1
	mr_program_file.write(tab * left_brackets + "}\n")




