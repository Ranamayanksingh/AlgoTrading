import concurrent.futures
import time

import DataDownloader.Stocks as st
import datetime as dt
import Reader.CSVReader as csvReader
import utils.Utils as utils
def hello():
    print("Hello world")

def task_function(ticker,start_date,end_date,base_folder_path):
    print(f"Started downloading data for ticker {ticker} . Start date : {start_date} , end date : {end_date}")
    yfinTickerName=ticker[0]+".NS"
    period='1d'
    interval='1d'
    tickerPath = base_folder_path +"/"+yfinTickerName+".csv"
    data = st.downloadData(start_date,end_date,yfinTickerName,period,interval)
    data.to_csv(tickerPath)
    return f"Result from task : download completed for ticker ticker {ticker} . Start date : {start_date} , end date : {end_date}"


if __name__ == "__main__":
    hello()

    # path="/Users/mayanksinghrana/AlgoTrading/Data/SBIN_day.csv"
    data = csvReader.read_csv("/Users/mayanksinghrana/AlgoTrading/Data/TickerSymbols.csv")
    basePath="/Users/mayanksinghrana/AlgoTrading/Data/1d"
    startTime=dt.datetime.today()-dt.timedelta(2)
    tickerStartTime = '2024-08-27'
    endTime = dt.datetime.today()-dt.timedelta(0)
    tickerEndDate = '2024-08-28'
    startEpoch = 1691034300
    endEpoch  = 1691033400
    testTime = dt.datetime.fromtimestamp(startEpoch)
    baseFolder = basePath + "/" + tickerStartTime
    utils.create_directory(baseFolder)

    # print(startTime ," ",tickerStartTime)
    # print(testTime)

    # period='1d'
    # interval='1d'
    # print(startTime)
    # for ticker in data:
    #     print(ticker)
    #     yfinTickerName=ticker[0]+".NS"
    #     baseFolder = basePath+interval+"/"+startTime.date().strftime('%Y-%m-%d')
    #     utils.create_directory(baseFolder)
    #     tickerPath = basePath+interval+"/"+startTime.date().strftime('%Y-%m-%d')+"/"+yfinTickerName+".csv"
    #     print(tickerPath)
    #     data = st.downloadData(tickerStartTime,tickerEndDate,yfinTickerName,period,interval)
    #     data.to_csv(tickerPath)
        # time.sleep(2)


    # parallel execution for speedup


    with concurrent.futures.ThreadPoolExecutor(max_workers=10) as executor:
        futures = [executor.submit(task_function(ticker,tickerStartTime,tickerEndDate,baseFolder)) for ticker in data]

    print("End of donwload all tickers data!!!")




