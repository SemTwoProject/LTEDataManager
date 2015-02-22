package com.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.InputModeDAO;
import com.dao.OSTypeDAO;
import com.dao.UEDAO;
import com.dao.UETypeDAO;
import com.entity.UE;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class UEDAOImpl implements UEDAO {

	@PersistenceContext
	private EntityManager em;

	public void createUEs() {
		ArrayList<UE> ues = new ArrayList<UE>();
		UETypeDAO type = new UETypeDAOImpl();
		OSTypeDAO os = new OSTypeDAOImpl();
		InputModeDAO inputMode = new InputModeDAOImpl();
		ues.add(new UE(100100, "G410", "Mitsubishi", "GSM 1800, GSM 900",
				"G410", "Mitsubishi", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(100200, "A53", "Siemens", "GSM 1900, GSM850 (GSM800)",
				"A53", "Siemens", os.getByOSType("(null)"), inputMode
						.getByInputMode("BASIC"), type.getByUEType("(null)")));
		ues.add(new UE(100300, "TBD (AAB-1880030-BV)", "Sony Ericsson",
				"GSM 1900, GSM850 (GSM800)", "TBD (AAB-1880030-BV)",
				"Sony Ericsson", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(100400, "RM-669", "Nokia", "GSM 1900, GSM850 (GSM800)",
				"RM-669", "Nokia", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(100500, "M930 NA DB", "Motorola",
				"GSM 1900, GSM850 (GSM800)", "M930 NA DB", "Motorola", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("HANDHELD")));
		ues.add(new UE(100600, "EBX700", "Panasonic",
				"GSM 1800, GSM 1900, GSM 900", "EBX700", "Panasonic", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(100700, "Test IMEI", "Sagem", "GSM 1900", "Test IMEI",
				"Sagem", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(100800, "TCD718", "Philips", "GSM 1900", "TCD718",
				"Philips", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(100900, "Test IMEI", "Sony", "GSM 1900", "Test IMEI",
				"Sony", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(101000, "Test IMEI",
				"Casio Hitachi Mobile Communications", "GSM 1900", "Test IMEI",
				"Casio Hitachi Mobile Communications",
				os.getByOSType("(null)"), inputMode.getByInputMode("(null)"),
				type.getByUEType("(null)")));
		ues.add(new UE(101300, "LMU", "Nortel", "GSM 1900", "LMU", "Nortel", os
				.getByOSType("(null)"), inputMode.getByInputMode("(null)"),
				type.getByUEType("(null)")));
		ues.add(new UE(101500, "GX-28", "Sharp",
				"GSM 1800, GSM 1900, GSM850 (GSM800)", "GX-28", "Sharp", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type
						.getByUEType("HANDLEHELD")));
		ues.add(new UE(101600, "ALCATEL OT-807A", "TCT Mobile Suzhou Limited",
				"GSM 1900, GSM850 (GSM800)", "ALCATEL OT-807A",
				"TCT Mobile Suzhou Limited", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(101700, "Wireless CPU Q2687", "Wavecom",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)",
				"Wireless CPU Q2687", "Wavecom", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("M2M")));
		ues.add(new UE(101710, "WMO2-g1900", "Wavecom", "GSM 1900",
				"WMO2-g1900", "Wavecom", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("M2M")));
		ues.add(new UE(
				101800,
				"Ovation MC547",
				"Novatel Wireless",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band V",
				"Ovation MC547", "Novatel Wireless", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("PC")));
		ues.add(new UE(102000, "RAP40GW", "RIM", "GSM 1800, GSM 900",
				"RAP40GW", "RIM", os.getByOSType("BLACKBERRY"), inputMode
						.getByInputMode("QWERTY"), type.getByUEType("HANDHELD")));
		ues.add(new UE(102100, "MX-5010", "Shintom Co. Ltd",
				"GSM 1800, GSM 1900, GSM 900", "MX-5010", "Shintom Co. Ltd", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(102200, "Zoarmon", "Intel",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "Zoarmon",
				"Intel", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(102300, "SGH-t829", "Samsung",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "SGH-t829",
				"Samsung", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("HANDHELD")));
		ues.add(new UE(102400, "Telguard 5 (TG5)", "Telular Corp",
				"GSM 1900, GSM850 (GSM800)", "Telguard 5 (TG5)",
				"Telular Corp", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(102500, "Fizgig", "Option NV",
				"GSM 1800, GSM 1900, GSM 900", "Fizgig", "Option NV", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(102600, "KMP6J1S1-6", "NEC",
				"GSM 1800, GSM 1900, GSM 900", "KMP6J1S1-6", "NEC", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(
				102700,
				"USB316",
				"Sierra Wireless",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II",
				"USB316", "Sierra Wireless", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("PC")));
		ues.add(new UE(102800, "U1", "Danger Inc.",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "U1",
				"Danger Inc.", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(102900, "Ferry", "Quanta Computer", "GSM 1900", "Ferry",
				"Quanta Computer", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(103000, "700C", "Intermec Technologies Corp.",
				"GSM 1800, GSM 1900, GSM 900", "700C",
				"Intermec Technologies Corp.", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(103100, "K1", "Sendo Ltd", "GSM 1900, GSM850 (GSM800)",
				"K1", "Sendo Ltd", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(103200, "7525 Workabout pro", "Psion Teklogix Inc.",
				"GSM 1800, GSM 1900, GSM 900", "7525 Workabout pro",
				"Psion Teklogix Inc.", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(103300, "Benefon Track Box", "benefon oyj",
				"GSM 1900, GSM 900", "Benefon Track Box", "benefon oyj", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(
				103500,
				"AD600",
				"LG",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band V",
				"AD600", "LG", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("HANDHELD")));
		ues.add(new UE(103600, "GSM5108", "Enfora", "GPRS", "GSM5108",
				"Enfora", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(M2M)")));
		ues.add(new UE(103700, "TM3000-C ATD", "Trimble",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "TM3000-C ATD",
				"Trimble", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(103800, "G1000", "Sanyo", "GSM 1800, GSM 1900, GSM 900",
				"G1000", "Sanyo", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(103900, "AGM 1100", "Accetio, Inc.",
				"GSM 1800, GSM 1900, GSM 900", "AGM 1100", "Accetio, Inc.", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104100, "ITH155/MGH900", "Mirae Comm Co Ltd",
				"GSM 1800, GSM 1900, GSM 900", "ITH155/MGH900",
				"Mirae Comm Co Ltd", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104200, "CF-29/CF-18/CF-73/CF-P1", "Matsushita",
				"GSM 1800, GSM 1900, GSM850 (GSM800)",
				"CF-29/CF-18/CF-73/CF-P1", "Matsushita", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104400, "H6xxx", "Compal Com.inc",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "H6xxx",
				"Compal Com.inc", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104500, "Artema Mobile Secure GPRS",
				"Thales e-Transactions GmbH", "GSM 1900, GSM850 (GSM800)",
				"Artema Mobile Secure GPRS", "Thales e-Transactions GmbH", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104600, "TS34", "Toshiba", "GSM 1800, GSM 900", "TS34",
				"Toshiba", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104700, "PLD", "PowerLOC Technologies Inc.",
				"GSM 1900, GSM850 (GSM800)", "PLD",
				"PowerLOC Technologies Inc.", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(104800, "1000-1146", "Arbitron", "GSM 1800, GSM 900",
				"1000-1146", "Arbitron", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(105000, "GU-1000", "Curitel",
				"GSM 1800, GSM 1900, GSM 900", "GU-1000",
				"Curitel Communications. Inc.", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(105200, "VK530", "VK Corporation",
				"GSM 1900, GSM850 (GSM800)", "VK530", "VK Corporation", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(105300, "BM3-891G GPRS OEM Modem", "Wavenet Technology",
				"GPRS", "BM3-891G GPRS OEM Modem", "Wavenet Technology", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("M2M")));

		ues.add(new UE(105400, "P7", "Qingdao Haier Telecom",
				"GSM 1800, GSM 1900, GSM 900", "P7", "Qingdao Haier Telecom",
				os.getByOSType("(null)"), inputMode.getByInputMode("(null)"),
				type.getByUEType("(null)")));

		ues.add(new UE(105500, "PLD100 series", "Destinator Technologies",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)",
				"PLD100 series", "Destinator Technologies", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(105600, "Jembi", "Psitek", "GSM 1900, GSM850 (GSM800)",
				"Jembi", "Psitek", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(105700, "U-300", "Telian",
				"GSM 1800, GSM 1900, GSM 900", "U-300", "Telian", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(105900, "DM1000G", "Waxess Inc",
				"GSM 1900, GSM850 (GSM800)", "DM1000G", "Waxess Inc", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(106200, "SM5100B", "Spreadtrum",
				"GSM 1900, GSM850 (GSM800)", "SM5100B", "Spreadtrum", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("M2M")));

		ues.add(new UE(106400, "Debussy", "CMCS",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "Debussy",
				"CMCS", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(106500, "GX820", "CalAmp", "GSM 1900, GSM850 (GSM800)",
				"GX820", "CalAmp", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(106600, "WRTU54G", "Cisco Systems", "GSM 1800, GSM 900",
				"WRTU54G", "Cisco Systems", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(106700, "whereQube201", "Geometris",
				"GSM 1800, GSM 1900, GSM850 (GSM800)", "whereQube201",
				"Geometris", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(106900, "R100", "Firefly Mobile",
				"GSM 1900, GSM850 (GSM800)", "R100", "Firefly Mobile", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(107100, "Dolphin 9900",
				"Handheld Products, Inc d/b/a HHP",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "Dolphin 9900",
				"Handheld Products, Inc d/b/a HHP", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(107200, "Test IMEI", "Apple",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "Test IMEI",
				"Apple", os.getByOSType("IOS"), inputMode
						.getByInputMode("TOUCH_SCREEN"), type
						.getByUEType("(null)")));

		ues.add(new UE(107400, "Nurit 8020", "VeriFone",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "Nurit 8020",
				"VeriFone", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(
				107600,
				"SN-Lsb-02",
				"Savi Networks",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band V",
				"SN-Lsb-02", "Savi Networks", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(
				107700,
				"IMM6071-M01",
				"InterDigital",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band IV, WCDMA FDD Band V",
				"IMM6071-M01", "InterDigital", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(107800, "247910", "Garmin International",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)", "247910",
				"Garmin International", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(107900, "Machine Gateway", "Phoenix International",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)",
				"Machine Gateway", "Phoenix International", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(108000, "XP3300-AR1 (P25C005AA)", "Sonim Technologies",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800)",
				"XP3300-AR1 (P25C005AA)", "Sonim Technologies", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(
				108100,
				"TSN-1.1",
				"Elektrobit Inc",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band II, WCDMA FDD Band V",
				"TSN-1.1", "Elektrobit Inc", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(
				108200,
				"Dolphin 10K",
				"Honeywell",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band V",
				"Dolphin 10K", "Honeywell", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(
				108300,
				"WWH9010",
				"Askey Computer Corp",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band V",
				"WWH9010", "Askey Computer Corp", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(
				108400,
				"Gobi3000",
				"Qualcomm",
				"GSM 1800, GSM 1900, GSM 900, GSM850 (GSM800), WCDMA FDD Band I, WCDMA FDD Band II, WCDMA FDD Band IV, WCDMA FDD Band V, WCDMA FDD Band VIII",
				"Gobi3000", "Qualcomm", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("PC")));

		ues.add(new UE(116000, "Test IMEI", "Omnipoint", "GSM 1900",
				"Test IMEI", "Omnipoint", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(21060800, "VEA3", "S.A.R.L. B  & B International",
				"GSM 1800, GSM 900", "VEA3", "S.A.R.L. B  & B International",
				os.getByOSType("(null)"), inputMode.getByInputMode("(null)"),
				type.getByUEType("(null)")));

		ues.add(new UE(33000153, "9109 PA", "Alcatel Radiotelephone (LAVAL)",
				"GSM 900", "9109 PA", "Alcatel Radiotelephone (LAVAL)", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(33000253, "Dirland Miniphone",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Dirland Miniphone", "Alcatel Radiotelephone (LAVAL)", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(33000353, "9109PA", "Alcatel Radiotelephone", "GSM 900",
				"9109PA", "Alcatel Radiotelephone", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(33000453, "Lisa 9030 Type 9109H",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Lisa 9030 Type 9109H", "Alcatel Radiotelephone (LAVAL)", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33000553, "Dirland Mobiphone",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Dirland Mobiphone", "Alcatel Radiotelephone (LAVAL)", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(33000635, "Mitsubishi GSM MT-1000F02A",
				"Mitsubishi Electric France", "GSM 900",
				"Mitsubishi GSM MT-1000F02A", "Mitsubishi Electric France", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(33000753, "Audiovox Type GSM 510",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Audiovox Type GSM 510", "Alcatel Radiotelephone (LAVAL)", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));

		ues.add(new UE(33000853, "Dirland Type Miniphone III",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Dirland Type Miniphone III", "Alcatel Radiotelephone (LAVAL)",
				os.getByOSType("(null)"), inputMode.getByInputMode("(null)"),
				type.getByUEType("(null)")));

		ues.add(new UE(33000953, "GSM 510 Type Audiovox HB 160",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"GSM 510 Type Audiovox HB 160",
				"Alcatel Radiotelephone (LAVAL)", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001053, "Vodafone VN 2121",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Vodafone VN 2121", "Alcatel Radiotelephone (LAVAL)", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001195, "Sagem Type G 14", "Sagem", "GSM 900",
				"Sagem Type G 14", "Sagem", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001235, "RC410/430 Type G14-1", "Sagem", "GSM 900",
				"RC410/430 Type G14-1", "Sagem", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001295, "RC410/430 Type G14-1", "Sagem", "GSM 900",
				"RC410/430 Type G14-1", "Sagem", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001453, "Pocketline Tango Type NPTT HC 400",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Pocketline Tango Type NPTT HC 400",
				"Alcatel Radiotelephone (LAVAL)", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001553, "Alcatel Airtel HC 600 Type Airtel HC 600",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Alcatel Airtel HC 600 Type Airtel HC 600",
				"Alcatel Radiotelephone (LAVAL)", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001635, "Affinity/Affinity 930 Type G14-S", "Sagem",
				"GSM 900", "Affinity/Affinity 930 Type G14-S", "Sagem", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001695, "Affinity/Affinity 930 Type G14-S", "Sagem",
				"GSM 900", "Affinity/Affinity 930 Type G14-S", "Sagem", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001735, "Mitsubishi GSM MT 20 Type MT 1171FD2",
				"Mitsubishi Electric France", "GSM 900",
				"Mitsubishi GSM MT 20 Type MT 1171FD2",
				"Mitsubishi Electric France", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001835, "Mitsubishi GSM MT 10 Type MT 1176F02",
				"Mitsubishi Electric France", "GSM 900",
				"Mitsubishi GSM MT 10 Type MT 1176F02",
				"Mitsubishi Electric France", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33001953, "Alcatel 9100 Type 9109 HC 500",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Alcatel 9100 Type 9109 HC 500",
				"Alcatel Radiotelephone (LAVAL)", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002053, "Alcatel 9100 Type 9109 HC 800",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Alcatel 9100 Type 9109 HC 800",
				"Alcatel Radiotelephone (LAVAL)", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002135, "Detewe CP-ONE Type G14.1", "Sagem",
				"GSM 900", "Detewe CP-ONE Type G14.1", "Sagem", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002195, "Detewe CP-ONE Type G14.1", "Sagem",
				"GSM 900", "Detewe CP-ONE Type G14.1", "Sagem", os
						.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002235, "RM 833-/S/R Type G14-S", "Sagem", "GSM 900",
				"RM 833-/S/R Type G14-S", "Sagem", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002295, "RM 833-/S/R Type G14-S", "Sagem", "GSM 900",
				"RM 833-/S/R Type G14-S", "Sagem", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002353,
				"Alcatel Movistar HC 100 Type Telefonica HC 1000",
				"Alcatel Radiotelephone (LAVAL)", "GSM 900",
				"Alcatel Movistar HC 100 Type Telefonica HC 1000",
				"Alcatel Radiotelephone (LAVAL)", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002499, "SGH 200", "Samsung", "GSM 900", "SGH 200",
				"Samsung", os.getByOSType("(null)"), inputMode
						.getByInputMode("(null)"), type.getByUEType("HANDHELD")));
		ues.add(new UE(33002535, "Mitsubishi GSM MT11 Type MT 1177 F02A",
				"Mitsubishi Electric France", "GSM 900",
				"Mitsubishi GSM MT11 Type MT 1177 F02A",
				"Mitsubishi Electric France", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		ues.add(new UE(33002635, "Mitsubishi GSM MT20 D Type MT 1172 F02A",
				"Mitsubishi Electric France", "GSM 900",
				"Mitsubishi GSM MT20 D Type MT 1172 F02A",
				"Mitsubishi Electric France", os.getByOSType("(null)"),
				inputMode.getByInputMode("(null)"), type.getByUEType("(null)")));
		for(UE ue: ues){
			em.persist(ue);
		}
	}

	public Collection<UE> getUE() {
		Query q = em.createQuery("select u from UE u");
		return q.getResultList();
	}

	public UE getByTac(Integer tac) {
		Query q = em.createQuery("select u from UE u where u.tac ='" + tac+"'",
				UE.class);
		List<UE> ul = q.getResultList();
		return ul.get(0);
	}
}