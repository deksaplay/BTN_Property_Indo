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

WebUI.openBrowser('https://www.btnproperti.co.id/tools/hitung-harga-properti')

WebUI.maximizeWindow()

// Verify element page kpr
WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Ajukan KPR'), 
    2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Blog'), 2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_List Developer'), 
    2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Promo'), 2)

WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/a_Tools'), 2)

WebUI.setText(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_penghasilan'), penghasilan)

WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/input_Pengeluaran'), 
    pengeluaran)

WebUI.takeScreenshot()

WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/select_Jangka Waktu'), 
    jangkaWaktu)

WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/button_Hitung'))

// Verifikasi error
WebUI.verifyElementPresent(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Properti  Indonesia/Verify/verify_error'), 
    10)

WebUI.takeScreenshot()
WebUI.closeBrowser()

