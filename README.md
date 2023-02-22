# meta-debix Layer

This README file contains information on the contents of the meta-debix layer.

Please see the corresponding sections below for details.

## Dependencies

  * imx-yocto-bsp(imx-5.15.71-2.2.0)

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
$ repo init -u https://github.com/nxp-imx/imx-manifest -b imx-linux-hardknott -m imx-5.15.71-2.2.0
$ repo sync
$ DISTRO=fsl-imx-wayland MACHINE=imx8mp-lpddr4-evk source imx-setup-release.sh -b build
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
MACHINE = "imx8mp-debix-a"
```

###  Run bitbake

For example build imx-image-base

```txt
$ bitbake imx-image-base
```

## Using Official kernel and u-boot

If you want to use the DEBIX official version of kernel and u-boot.

Set "debix-a" to MACHINE in the local.conf as follows:

```
MACHINE = "debix-a"
```

### Limitation

The DEBIX official version of kernel is 5.10.

However the GPU driver (kernel-module-imx-gpu-viv) expects the version of kernel is 5.15,
then cannot use the GPU related functions with official kernel on the main branch.

If you want to use the official version of kernel with GPU, try to use the hardknott branch and imx-yocto-bsp(imx-5.10.72-2.2.0).
