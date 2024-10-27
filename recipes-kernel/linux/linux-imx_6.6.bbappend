FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0001-arm64-dts-imx8mp-debix-model-a-Fix-a-symbol.patch \
        file://0001-arm64-dts-imx8mp-debix-model-a-Add-a-supply-to-usb3_.patch \
	file://0002-arm64-dts-imx8mp-debix-model-a-Enable-the-HDMI.patch \
"
