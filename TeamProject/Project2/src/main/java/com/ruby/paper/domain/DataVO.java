package com.ruby.paper.domain;

import org.springframework.stereotype.Repository;

@Repository
public class DataVO {

	private String car_num; //차량번호
	private int distance; //운행거리
	private int distance_cum; //누적운행거리
	private double speed_av; //평균운행속도
	private int speed_max; //최고속도
	private int opertating_time; //운행시간
	private int stop_num; //운행중 정지건수
	private int stop_time;//운행중 정지시간
	private double stop_rate;//운행중 정지비율
	private int drive_time;//운행중 주행시간
	private int rpm_max; // 최고 rpm
	private int rpm_av; //평균 rpm
	private boolean result; //판단

	public DataVO() {

	}

	public DataVO(String car_num, int distance, int distance_cum, double speed_av, int speed_max, int opertating_time,
			int stop_num, int stop_time, double stop_rate, int drive_time, int rpm_max, int rpm_av, boolean result) {
		super();
		this.car_num = car_num;
		this.distance = distance;
		this.distance_cum = distance_cum;
		this.speed_av = speed_av;
		this.speed_max = speed_max;
		this.opertating_time = opertating_time;
		this.stop_num = stop_num;
		this.stop_time = stop_time;
		this.stop_rate = stop_rate;
		this.drive_time = drive_time;
		this.rpm_max = rpm_max;
		this.rpm_av = rpm_av;
		this.result = result;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance_cum() {
		return distance_cum;
	}

	public void setDistance_cum(int distance_cum) {
		this.distance_cum = distance_cum;
	}

	public double getSpeed_av() {
		return speed_av;
	}

	public void setSpeed_av(double speed_av) {
		this.speed_av = speed_av;
	}

	public int getSpeed_max() {
		return speed_max;
	}

	public void setSpeed_max(int speed_max) {
		this.speed_max = speed_max;
	}

	public int getOpertating_time() {
		return opertating_time;
	}

	public void setOpertating_time(int opertating_time) {
		this.opertating_time = opertating_time;
	}

	public int getStop_num() {
		return stop_num;
	}

	public void setStop_num(int stop_num) {
		this.stop_num = stop_num;
	}

	public int getStop_time() {
		return stop_time;
	}

	public void setStop_time(int stop_time) {
		this.stop_time = stop_time;
	}

	public double getStop_rate() {
		return stop_rate;
	}

	public void setStop_rate(double stop_rate) {
		this.stop_rate = stop_rate;
	}

	public int getDrive_time() {
		return drive_time;
	}

	public void setDrive_time(int drive_time) {
		this.drive_time = drive_time;
	}

	public int getRpm_max() {
		return rpm_max;
	}

	public void setRpm_max(int rpm_max) {
		this.rpm_max = rpm_max;
	}

	public int getRpm_av() {
		return rpm_av;
	}

	public void setRpm_av(int rpm_av) {
		this.rpm_av = rpm_av;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DataVO [car_num=" + car_num + ", distance=" + distance + ", distance_cum=" + distance_cum
				+ ", speed_av=" + speed_av + ", speed_max=" + speed_max + ", opertating_time=" + opertating_time
				+ ", stop_num=" + stop_num + ", stop_time=" + stop_time + ", stop_rate=" + stop_rate + ", drive_time="
				+ drive_time + ", rpm_max=" + rpm_max + ", rpm_av=" + rpm_av + ", result=" + result + "]";
	}

}