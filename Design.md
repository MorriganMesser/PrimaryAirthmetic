#Project Structure

## Web Structure
 - 登录页面=>注册页面:点击注册
 - 注册页面=>登录页面:注册成功
 - 注册页面=>弹出错误:注册失败
 - 登录页面=>主页:点击登录
 - 登录页面=>弹出错误:登录失败
 - 主页=>考试页面:选择题库，点击考试
 - 考试页面=>结果页面:点击提交
 - 主页=>记录页面:点击查看记录

## Function Structure
 - 数字类NumberClass
 - 表达式生成&&表达式计算=>题库生成 && 答案生成=>结果生成&&记录生成  

### 表达式的形式化描述
```
Expression: Expression add Term | Term
Term:       Term multi Factor | Factor
Factor:     leftp Expression rightp | Number
Number:     digits (div digits)?
add:        '+' | '-'
multi:      '*'
digits:     [1-9][0-9]*
leftp:      '('
rightp:     ')'
div:        '/'
```

### 生成题目接口
 - 题目类：Expression
 - 构造函数：Expression(fractionRatio, scale, grade, fractionScale, fractionNumber)
   - 默认参数分别为50，20，1，10，2
   - fractionRatio: 分数出现的比率，取值范围为[0, 100]
   - scale: 表达式中出现的数字最大值，取值范围[5, 10000]
   - grade: 表达式等级，取值范围[0, 3]，0代表只有加法，3代表包含加减乘除
   - fractionScale: 分数中出现的数字最大值，取值范围[5, 100]
   - fractionNumber: 表达式包含的操作数个数，取值范围[2, 10]
 - 设置参数：
   - setFractionRatio(fractionRatio)
   - setScale(scale)
   - setGrade(grade)
   - setFractionScale(fractionScale)
   - setFractionNumber(fractionNumber)
 - 获取当前参数：
   - getFractionRatio()
   - getScale()
   - getGrade()
   - getFractionScale()
   - getFractionNumber()
 - 生成题目：void createExpression(String type)
   - 每次调用产生一个表达式
   - type $\in$ {"mathjax", "linear"}，表示渲染方式，默认为"mathjax"
 - 获取题目：String getExpression()
 - 获取结果：String getResult()
   - 注：结果不会随type变化，均为“a/b”的形式（若b为1则不显示“/b”）

# 开发环境
 - spring + tomcat + mysql
 - java + HTML + CSS + javascript

## 平台
 - JavaWeb

## 前端
 - bootstrap
 
# 代码规范

## 命名规范
1. JAVA文件：每个单词首字母大写
2. 网页文件：全部小写
3. 方法名：第一个单词首字母小写之后首字母大写
4. 类名：每个单词首字母大写
5. 变量名：第一个单词首字母小写之后首字母大写

## 其它
 - 暂无

# 分工
1. 前端
 - 负责人：马舒婕、仇强
 - 任务：寻找合适的模板，完成网站的网页
2. 功能
 - 负责人：刘凯、尉智辉
 - 任务：实现后台试卷生成、打分、记录等功能
3. 接口
 - 负责人：田红策
 - 任务：处理页面请求如注册、登录等，实现网页与功能模块以及功能模块与数据库的接口
