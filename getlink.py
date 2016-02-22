# coding:utf-8
import re
file = open("aaa.txt")
content = file.read()
link_list = re.findall(r"(?<=href=\").+?(?=\")|(?<=href=\').+?(?=\')" ,content)
for url in link_list:
    print '"http://www.liaoxuefeng.com' + url + '",'
