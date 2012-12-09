1级实践_巩晓冬_GS1221761_刘亮_GS1221362_谢春雨_GS1221569

运行说明：
1.本程序运行需要jdk1.7或者以上版本；
2.运行前需要正确设置jdk的运行环境；
3.完成后请执行startup.bat或者java -jar levelOne.jar。

测试分解：
需求一：
  一个停车场，可以进行停车、取车等操作。并可以显示空车位数量。
	a.分解：
		1.当停入一辆车时，空车位数量减一；
		2.当取走一辆车时，空车位数量加一；
		3.当停车场已满时，再进行停车时将失败；
		4.当停车场为空时，再进行取车时将失败；
		5.当使用正确的停车票据取车时，取出的车即为原来停的那辆车；
		6.当使用错误的停车票据取车时，取车将失败；
		7.当使用正确的停车票据进行两次取车时，取车将失败；

需求二：
	来了一个停车BOY，他可以管理多个停车场，也可以进行停取车。
	a.数据初始化：
		这个停车BOY管理一个5车位的停车场和一个10车位的停车场。
	b.分解：
		1.使用默认策略停15辆车时，测试每停一辆车后两个停车场的空车位。分析数据如下：
			停车数    第一个停车场停车数     第二个停车场停车数
			  0               0                    0
			  1               1                    0
			  2               2                    0
			  3               3                    0
			  4               4                    0
			  5               5                    0
			  6               5                    1
			  7               5                    2
			  8               5                    3
			  9               5                    4
			 10               5                    5
			 11               5                    6
			 12               5                    7
			 13               5                    8
			 14               5                    9
			 15               5                    10
		2.停一辆车在第一个停车场，通过停车票据取出的车就是原来停的车；
		3.停一辆车在第二个停车场，通过停车票据取出的车就是原来停的车；
		4.当所有停车场没有停车时，再进行取车时失败；
		5.当所有停车场已满，再进行停车时失败；
		6.使用默认策略停15辆车时，测试每停一辆车后停车BOY所管理的所有停车场的空车位。

需求三：
	来了一个聪明的停车BOY，他会根据停车场停车数量来决定将车停在哪。
	a.数据初始化：
		沿用原来的初始化数据，这个停车BOY管理一个5车位的停车场和一个10车位的停车场。
	b.分解：
		1.使用平均策略停15辆车时，测试每停一辆车后两个停车场的空车位。分析数据如下：
			停车数    第一个停车场停车数     第二个停车场停车数
			  0               0                    0
			  1               1                    0
			  2               1                    1
			  3               2                    1
			  4               2                    2
			  5               3                    2
			  6               3                    3
			  7               4                    3
			  8               4                    4
			  9               5                    4
			 10               5                    5
			 11               5                    6
			 12               5                    7
			 13               5                    8
			 14               5                    9
			 15               5                    10
		2.使用平均策略停15辆车时，测试每停一辆车后停车BOY所管理的所有停车场的空车位。

需求四：
	来了一个超级停车BOY，按照所管理的停车场的空置率来进行停车。当需要停车时，优先停在空置率高的停车场。
	a.数据初始化：
		沿用原来的初始化数据，这个停车BOY管理一个5车位的停车场和一个10车位的停车场。
	b.分解：
		1.使用空置率策略停15辆车时，测试每停一辆车后两个停车场的空车位。分析数据如下：
			停车数    第一个停车场停车数   第一个停车场空置率     第二个停车场停车数   第二个停车场空置率
			  0               0                  100%                   0                  100%
			  1               1                   80%                   0                  100%
			  2               1                   80%                   1                   90%
			  3               1                   80%                   2                   80%
			  4               2                   60%                   2                   80%
			  5               2                   60%                   3                   70%
			  6               2                   60%                   4                   60%
			  7               3                   40%                   4                   60%
			  8               3                   40%                   5                   50%
			  9               3                   40%                   6                   40%
			 10               4                   20%                   6                   40%
			 11               4                   20%                   7                   30%
			 12               4                   20%                   8                   20%
			 13               5                    0%                   8                   20%
			 14               5                    0%                   9                   10%
			 15               5                    0%                  10                    0%
		2.使用空置率策略停15辆车时，测试每停一辆车后停车BOY所管理的所有停车场的空车位。
		
需求五：
	停车场经理“驾到”，他可以管理多个停车BOY，让他们去停车，同时也可以自己随机停车。
	a.数据初始化：
		设置停车场经理管理了一个8个停车位的停车场，同时还管理着一个拥有一个5车位的停车场和一个9车位的停车场的停车BOY和一个拥有4车位的停车场和7车位的停车场的停车BOY。
	b.分解：
		1.当停33辆车时，测试每停一辆车时停车场经理的空车位数量；
		2.当所有停车场已满，再进行停车时失败；
		3.停一辆车时，根据票据取出来的车还是原来停的那辆车。

需求六：
	停车场经理可以查看自己的停车场和所管理的多个停车BOY的停车场的车位信息。
	可以查看的信息如下：
		停车场编号：
			车位数：
			空位数：	
		停车仔编号：
			停车场编号：
				车位数：
				空位数：
			停车场编号：
				车位数：
				空位数：
			Total	车位数：
			Total	空位数：	
		停车仔编号：
			停车场编号：
				车位数：
				空位数：
			停车场编号：
				车位数：
				空位数：
			Total	车位数：
			Total	空位数：
		Total	车位数：
		Total	空位数：
	a.分解：在保证前面需求测试都通过的前提下，该需求无需测试。

需求七：
	停车场主管出场，可以查看所有停车场的车位信息。
	可以查看的信息如下：
		停车场编号：
			车位数：
			空位数：
		Total	车位数：
		Total	空位数：		
		停车场编号：
			车位数：
			空位数：
		Total	车位数：
		Total	空位数：
	a.分解：在保证前面需求测试都通过的前提下，该需求无需测试。