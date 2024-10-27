# meta-debix Layer

This README file contains information on the contents of the meta-debix layer.

Please see the corresponding sections below for details.

## Dependencies

  * imx-yocto-bsp(imx-6.6.36_2.1.0)

## Patches

Please submit any patches against the meta-debix layer to the maintainer:

Maintainer: Yusuke Mitsuki <mickey.happygolucky@gmail.com>


## Build instruction

Build instruction as follows:

1. Setup the imx-yocto-bsp
2. Get the meta-debix
3. Add the meta-debix to build
4. Edit the local.conf
5. Run bitbake

### Setup the imx-yocto-bsp

```txt
$ repo init -u https://github.com/nxp-imx/imx-manifest -b imx-linux-hardknott -m imx-6.6.36_2.1.0
$ repo sync
$ DISTRO=fsl-imx-wayland MACHINE=imx8mp-debix-model-a source imx-setup-release.sh -b build
```

### Get the meta-debix

Get the meta-debix with git.
Move the meta-debix into source directory.

### Add the meta-debix to build

Do the commands in the build directory.

```txt
$ bitbake-layers add-layer ../sources/meta-debix
```

### Edit the local.conf

Add the line to `conf/local.conf` as follows.

```
MACHINE = "imx8mp-debix-model-a"
```

###  Run bitbake

For example build imx-image-base

```txt
$ bitbake imx-image-base
```

### Limitation

Available devices as follows:

* USB
* LAN
* HDMI
* Debug Serial(UART2)

Other devices, we have not confirmed its operation.
