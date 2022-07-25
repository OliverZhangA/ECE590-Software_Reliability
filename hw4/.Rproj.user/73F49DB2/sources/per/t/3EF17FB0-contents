HMP<-read.table(file="data/data1.csv", header=TRUE, sep=",")
head(HMP)
dim(HMP)
si=0
ssm=0
y=HMP
result<-matrix(nrow = 397,ncol=2)
for(i in 2:397){
  si<-0
  for(j in 1:i){
    si<-si+y[j,2]
  }
  ssm<-y[1,2]
  for(m in 2:i-1){
    for(j in 1:m){
      ssm<-ssm+y[j,2]
    }
  }
  result[i,2]<-((1/(i-1))*ssm - si/2)/(si*sqrt(1/(12*(i - 1))))
  print(result[i,2])
}
#print(y[,2])
plot(1:397, result[,2])
abline(h = 1.96,,col = "gray60")
abline(h = -1.96, col = "gray60")
