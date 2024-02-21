import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Pages/BTN_Properti/Page_Verify/Verify_Page_properti'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Pages/BTN_Properti/Input_penghasilan'), [('inputPenghasilan') : '50000000'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Pages/BTN_Properti/Input_pengeluaran'), [('inputPengeluaran') : '10000000000'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Pages/BTN_Properti/Select_jangka_waktu'), [('jangkaWaktu') : '3 Tahun'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Pages/BTN_Properti/Button_hitung'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Pages/BTN_Properti/Page_Verify/Verify_error'), [:], FailureHandling.STOP_ON_FAILURE)

